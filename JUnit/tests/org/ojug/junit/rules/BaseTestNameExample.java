package org.ojug.junit.rules;

import org.junit.Rule;
import org.junit.rules.TestName;

public abstract class BaseTestNameExample {

    @Rule
    public TestName name = new TestName();

    protected String readData() {
        return this.name.getMethodName();
    }

}
