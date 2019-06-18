package com.github.ianwillard.example.test;

import com.github.ianwillard.example.test.groups.Fast;
import com.github.ianwillard.example.test.groups.Slow;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(Fast.class)
public class FastTests {
    
    @Test
    public void fast() {
        System.out.println("this is a fast test");
        assert 1 == 1;
    }
}
