package com.github.ianwillard.testfilter;

public class FilterGroups {
    private String[] included;
    private String[] excluded;
    
    public FilterGroups(String[] included, String[] excluded) {
        this.included = included;
        this.excluded = excluded;
    }

    public int getIncludedCount() {
        return included.length;
    }

    public String getIncludedGroups() {
        return String.join(",", included);
    }

    public int getExcludedCount() {
        return excluded.length;
    }

    public String getExcludedGroups() {
        return String.join(",", excluded);
    }
}
