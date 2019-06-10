package org.ian.tools.maven.test;

import org.ian.tools.maven.test.groups.DB;
import org.ian.tools.maven.test.groups.Fast;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(DB.class)
public class MultilevelTests {

    @Category(Fast.class)
    @Test
    public void fastDb() {
        System.out.println("this is a multilevel fast db test");
        assert 1 == 1;
    }
}

