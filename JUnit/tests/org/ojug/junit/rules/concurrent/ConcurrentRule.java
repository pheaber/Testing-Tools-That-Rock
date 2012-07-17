package org.ojug.junit.rules.concurrent;

import java.util.concurrent.CountDownLatch;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

/**
 * Based off of http://blog.mycila.com/2009/11/writing-your-own-junit-extensions-using.html
 */
public final class ConcurrentRule implements MethodRule {

    @Override
    public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, final Object o) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                Concurrent concurrent = frameworkMethod.getAnnotation(Concurrent.class);
                if (concurrent == null) {
                    statement.evaluate();
                } else {
                    final String name = frameworkMethod.getName();
                    final Thread[] threads = new Thread[concurrent.value()];
                    final CountDownLatch go = new CountDownLatch(1);
                    final CountDownLatch finished = new CountDownLatch(threads.length);
                    for (int i = 0; i < threads.length; i++) {
                        threads[i] = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    go.await();
                                    statement.evaluate();
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                } catch (Throwable throwable) {
                                    if (throwable instanceof RuntimeException) {
                                        throw (RuntimeException) throwable;
                                    }
                                    if (throwable instanceof Error) {
                                        throw (Error) throwable;
                                    }
                                    RuntimeException r = new RuntimeException(throwable.getMessage(), throwable);
                                    r.setStackTrace(throwable.getStackTrace());
                                    throw r;
                                } finally {
                                    finished.countDown();
                                }
                            }
                        }, name + "-Thread-" + i);
                        threads[i].start();
                    }
                    go.countDown();
                    finished.await();
                }
            }
        };
    }

}
