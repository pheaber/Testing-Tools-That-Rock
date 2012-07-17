package org.ojug.junit;

import static org.junit.Assert.assertEquals;
import junitx.util.PrivateAccessor;

import org.junit.Test;

public class PrivateAccessorExamples {

    private static final String DATA_MEMBER_NAME = "data";

    private final SimpleStringList list = new SimpleStringList();

    @Test
    public void add() throws Exception {
        this.list.add("one");

        String[] data = (String[]) PrivateAccessor.getField(this.list, DATA_MEMBER_NAME);
        assertEquals("one", data[0]);
        assertEquals(1, this.list.count);
    }

    @Test
    public void get() throws Exception {
        String[] entries = { "one" };
        PrivateAccessor.setField(this.list, DATA_MEMBER_NAME, entries);
        this.list.count = 1;

        assertEquals("one", this.list.get(0));
        assertEquals(1, this.list.count);
    }

}
