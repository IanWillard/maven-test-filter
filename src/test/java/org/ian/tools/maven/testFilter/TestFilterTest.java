package org.ian.tools.maven.testFilter;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class TestFilterTest {

    private TestFilter target;

    @Before
    public void setup() {
        List<String> defs = new ArrayList<>();

        defs.add("sh1=cat1");
        defs.add("sh2=cat2");

        target = new TestFilter(defs);
    }

    @Test
    public void select__single_include_valid__success() {
        // when
        FilterGroups result = target.select("sh1");

        // then excluded is blank
        Assert.assertTrue(result.getExcludedGroups().isEmpty());

        // and included is "cat1"
        Assert.assertFalse(result.getIncludedGroups().isEmpty());
        Assert.assertTrue(result.getIncludedGroups().contains("cat1"));
    }

    @Test
    public void select__multiple_includes_valid__success() {
        // when
        FilterGroups result = target.select("sh1,sh2");

        // then excluded is blank
        Assert.assertTrue(result.getExcludedGroups().isEmpty());

        // and included is "cat1,cat2"
        Assert.assertFalse(result.getIncludedGroups().isEmpty());
        Assert.assertTrue(result.getIncludedGroups().contains("cat1"));
        Assert.assertTrue(result.getIncludedGroups().contains("cat2"));
    }

    @Test
    public void select__complex_valid__success() {
        // when
        FilterGroups result = target.select("sh1,-sh2");

        // then excluded is blank
        Assert.assertFalse(result.getExcludedGroups().isEmpty());
        Assert.assertTrue(result.getExcludedGroups().contains("cat2"));

        // and included is "cat1,cat2"
        Assert.assertFalse(result.getIncludedGroups().isEmpty());
        Assert.assertTrue(result.getIncludedGroups().contains("cat1"));
    }
}
