package org.ojug.junit;

import org.junit.Test;

public class ExpectedExceptionExamples {

    private final SimpleStringList list = new SimpleStringList();

    @Test(expected = IndexOutOfBoundsException.class)
    public void getForEmptyListThrowsException() {
        this.list.get(0);
    }

}
