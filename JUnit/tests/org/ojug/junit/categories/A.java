package org.ojug.junit.categories;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class A {

    @Test
    public void a() {
        fail();
    }

    @Category(SlowTests.class)
    @Test
    public void b() {
    }

}
