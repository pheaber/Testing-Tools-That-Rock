package org.ojug.junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ParameterizedExampleOldSchool {

    private static final List<Object[]> TEST_DATA = Arrays.asList(new Object[][] { //
            { 1, 1, 3 }, // this bit of bad data causes all the rest to not be tested
                    { 2, 6, 8 }, //
                    { 9, 3, 12 } //
            });

    private final SimpleCalculator calculator = new SimpleCalculator();

    @Test
    public void add() {
        for (Object[] testDatum : TEST_DATA) {
            int expectedResult = (Integer) testDatum[2];
            assertEquals(expectedResult, this.calculator.add((Integer) testDatum[0], (Integer) testDatum[1]));
        }
    }
}
