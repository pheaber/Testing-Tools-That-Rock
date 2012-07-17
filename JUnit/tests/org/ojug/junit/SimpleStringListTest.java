package org.ojug.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import junitx.util.PrivateAccessor;

import org.junit.Test;

public class SimpleStringListTest {

    private static final String DATA_MEMBER_NAME = "data";

    private final SimpleStringList list = new SimpleStringList();

    @Test
    public void isEmptyForNewListReturnsTrue() {
        assertTrue(this.list.isEmpty());
    }

    @Test
    public void isEmptyForNonEmptyListReturnsFalse() throws Exception {
        String[] entries = { "one" };
        PrivateAccessor.setField(this.list, DATA_MEMBER_NAME, entries);
        this.list.count = 1;

        assertFalse(this.list.isEmpty());
    }

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

    @Test(expected = IndexOutOfBoundsException.class)
    public void getForEmptyListThrowsException() {
        this.list.get(0);
    }

    @Test(timeout = 400)
    public void calculateTakesTooLong() {
        this.list.calculate();
    }

    @Test(timeout = 550)
    public void calculateHasEnoughTime() {
        this.list.calculate();
    }

}
