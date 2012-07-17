package org.ojug.junit.theories.supplier;

import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

/**
 * Wholly taken from http://blog.schauderhaft.de/2010/02/07/junit-theories/
 */
public class CreditCardSupplier extends ParameterSupplier {

    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature signature) {
        List<PotentialAssignment> result = new ArrayList<PotentialAssignment>();

        result.add(PotentialAssignment.forValue("Amex", "Amex"));
        result.add(PotentialAssignment.forValue("Master", "Master"));
        result.add(PotentialAssignment.forValue("Visa", "Visa"));

        return result;
    }
}