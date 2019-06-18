package com.github.ianwillard.example.test;

import com.github.ianwillard.example.test.groups.DB;
import com.github.ianwillard.example.test.groups.Fast;
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

