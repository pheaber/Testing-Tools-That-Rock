package org.ojug.junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedExamples {

    private final int addendOne;
    private final int addendTwo;

    private final int explectedResult;

    private final SimpleCalculator calculator = new SimpleCalculator();

    public ParameterizedExamples(int addendOne, int addendTwo, int expectedResult) {
        this.addendOne = addendOne;
        this.addendTwo = addendTwo;
        this.explectedResult = expectedResult;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { //
                { 1, 1, 3 }, // this piece of bad data fails, but the rest will still be tried!
                        { 2, 6, 8 }, //
                        { 9, 3, 12 } //
                });
    }

    @Test
    public void add() {
        assertEquals(this.explectedResult, this.calculator.add(this.addendOne, this.addendTwo));
    }

}
