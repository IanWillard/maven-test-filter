package org.ian.tools.maven.test;

import org.ian.tools.maven.test.groups.DB;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(DB.class)
public class DBTests {
    
    @Test
    public void db() {
        System.out.println("this is a db test");
        assert 1 == 1;
    }
}
