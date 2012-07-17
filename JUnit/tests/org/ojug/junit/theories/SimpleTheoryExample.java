package org.ojug.junit.theories;

import static org.junit.Assume.assumeTrue;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * Based off of http://blog.schauderhaft.de/2010/01/31/new-feature-of-junit-theories/
 */
@RunWith(Theories.class)
public class SimpleTheoryExample {

    @DataPoint
    public static String a = "a";

    @DataPoint
    public static String b = "bb";

    @DataPoint
    public static String c = "ccc";

    @Theory
    public void stringTest(String x, String y) {
        assumeTrue(x.length() > 1);

        // doesn't test anything, just shows how Theories are executed by passing all combinations of DataPoint
        System.out.println(x + " " + y);
    }

}
