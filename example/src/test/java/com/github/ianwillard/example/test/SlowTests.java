package com.github.ianwillard.example.test;

import com.github.ianwillard.example.test.groups.Slow;
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
