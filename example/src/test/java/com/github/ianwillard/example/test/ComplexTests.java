package com.github.ianwillard.example.test;

import com.github.ianwillard.example.test.groups.DB;
import com.github.ianwillard.example.test.groups.Fast;
import com.github.ianwillard.example.test.groups.Slow;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ComplexTests {

    @Category(DB.class)
    @Test
    public void db() {
        System.out.println("this is a complex db test");
        assert 1 == 1;
    }

    @Category(Fast.class)
    @Test
    public void fast() {
        System.out.println("this is a complex fast test");
        assert 1 == 1;
    }

    @Category(Slow.class)
    @Test
    public void slow() {
        System.out.println("this is a complex slow test");
        assert 1 == 1;
    }
}
