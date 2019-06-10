package org.ian.tools.maven.test;

import org.ian.tools.maven.test.groups.Slow;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(Slow.class)
public class SlowTests {

    @Test
    public void slow() {
        System.out.println("this is a slow test");
        assert 1 == 1;
    }
}
