package org.ojug.junit.theories.supplier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.experimental.theories.ParametersSuppliedBy;

/**
 * Wholly taken from http://blog.schauderhaft.de/2010/02/07/junit-theories/
 */
@Retention(RetentionPolicy.RUNTIME)
@ParametersSuppliedBy(NameSupplier.class)
public @interface AllNames {
}