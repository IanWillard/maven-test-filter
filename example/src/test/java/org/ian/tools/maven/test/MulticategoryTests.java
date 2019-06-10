package org.ian.tools.maven.test;

import org.ian.tools.maven.test.groups.DB;
import org.ian.tools.maven.test.groups.Fast;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MulticategoryTests {

    @Category({Fast.class, DB.class})
    @Test
    public void fastDb() {
        System.out.println("this is a multicategory fast db test");
        assert 1 == 1;
    }
}

