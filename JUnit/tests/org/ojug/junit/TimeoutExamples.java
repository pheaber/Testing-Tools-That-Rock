package org.ojug.junit;

import org.junit.Test;

public class TimeoutExamples {

    private final SimpleStringList list = new SimpleStringList();

    @Test(timeout = 400)
    public void calculateTakesTooLong() {
        this.list.calculate();
    }

    @Test(timeout = 550)
    public void calculateHasEnoughTime() {
        this.list.calculate();
    }

}
