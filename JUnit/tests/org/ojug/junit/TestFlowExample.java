package org.ojug.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFlowExample {

    @BeforeClass
    public static void init() {
        System.out.println("@BeforeClass - I run once before any test methods are executed.");
    }

    @AfterClass
    public static void cleanup() {
        System.out.println("@AfterClass - I run once after all tests methods are done.");
    }

    @Before
    public void setUp() {
        System.out
                .println("\t@Before - I run once before each test method. Let me help build new pieces needed for each test.");
    }

    @Before
    public void setUpOtherStuff() {
        System.out.println("\t@Before - More than one Before/After can be used.");
    }

    @After
    public void tearDown() {
        System.out.println("\t@After - I clean up after each test.");
    }

    @Test
    public void doStuff() {
        System.out.println("\t\t@Test - making sure doStuff() works.");
    }

    @Test
    public void doStuffDoesOtherStuff() {
        System.out.println("\t\t@Test - make sure doStuff() does other stuff too.");
    }

}
