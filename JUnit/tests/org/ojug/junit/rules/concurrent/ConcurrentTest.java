package org.ojug.junit.rules.concurrent;

import java.util.Random;

import org.junit.Rule;
import org.junit.Test;

/**
 * Based off of http://blog.mycila.com/2009/11/writing-your-own-junit-extensions-using.html
 */
public final class ConcurrentTest {

    @Rule
    public ConcurrentRule concurrentRule = new ConcurrentRule();

    @Test
    @Concurrent(15)
    public void myTestMethod() throws InterruptedException {
        System.out.println("Thread " + Thread.currentThread().getName() + " started !");
        int n = new Random().nextInt(5000);
        System.out.println("Thread " + Thread.currentThread().getName() + " wait " + n + "ms");
        Thread.sleep(n);
        System.out.println("Thread " + Thread.currentThread().getName() + " finished");
    }

}
