package org.ian.tools.maven.testFilter;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class TestFilter {

    private Map<String, String> groups = new HashMap<>();

    public TestFilter(List<String> definitions) {
        if (definitions.size() > 0) {
            for (String def : definitions) {
                String[] components = def.split("=");
                if (components.length != 2) {
                    throw new IllegalArgumentException("Category definitions must be of the form 'shorthand=classname' or 'shorthand=classname1,classname2,...'");
                }
                groups.put(components[0], components[1]);
            }
        }
    }

    public FilterGroups select(String selections) {
        String[] filters = selections.split(",");

        List<String> excluded = new ArrayList<>();
        List<String> included = new ArrayList<>();

        if (filters.length > 0) {
            for (String filter : filters) {
                if (!StringUtils.isBlank(filter)) {
                    if (isExcluded(filter)) {
                        excluded.add(filter.replaceFirst("-", ""));
                    } else {
                        included.add(filter.replaceFirst("\\+", ""));
                    }
                }
            }
        }

        return new FilterGroups(resolveGroups(included), resolveGroups(excluded));
    }

    private String[] resolveGroups(Collection<String> toResolve) {
        List<String> resolved = new ArrayList<>(toResolve.size());
        if (toResolve.size() > 0) {
            for (String filter : toResolve) {
                String path = groups.get(filter);
                if (path != null) {
                    resolved.add(path);
                }
            }
        }
        return resolved.toArray(new String[]{});
    }

    private boolean isExcluded(String group) {
        return group.startsWith("-");
    }
}
