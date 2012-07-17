package org.ojug.junit.theories.supplier;

import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

/**
 * Wholly taken from http://blog.schauderhaft.de/2010/02/07/junit-theories/
 */
public class NameSupplier extends ParameterSupplier {

    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature signature) {

        AllNames annotation = signature.getAnnotation(AllNames.class);
        System.out.println("just wanted to show that I can access it " + annotation);

        List<PotentialAssignment> result = new ArrayList<PotentialAssignment>();

        result.add(PotentialAssignment.forValue("Alf", "Alf"));
        result.add(PotentialAssignment.forValue("Willie", "Willie"));
        result.add(PotentialAssignment.forValue("Tanner", "Tanner"));
        result.add(PotentialAssignment.forValue("Cat", "Cat"));

        return result;
    }

}