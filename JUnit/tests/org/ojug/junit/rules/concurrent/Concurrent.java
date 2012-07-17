package org.ojug.junit.rules.concurrent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Based off of http://blog.mycila.com/2009/11/writing-your-own-junit-extensions-using.html
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface Concurrent {

    int value() default 10;

}
