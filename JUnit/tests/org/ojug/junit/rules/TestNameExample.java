package org.ojug.junit.rules;

import org.junit.Test;

public class TestNameExample extends BaseTestNameExample {

    @Test
    public void doStuff() {
        String data = readData();
        System.out.println("I got data from " + data);
    }

}
