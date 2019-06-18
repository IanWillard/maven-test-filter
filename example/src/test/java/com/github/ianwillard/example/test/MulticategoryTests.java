package com.github.ianwillard.example.test;

import com.github.ianwillard.example.test.groups.DB;
import com.github.ianwillard.example.test.groups.Fast;
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

