package org.ojug.junit;

import static org.junit.Assume.assumeNoException;
import static org.junit.Assume.assumeNotNull;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class AssumptionsExamples {

    @Test
    public void assumeNoExceptionFailureExample() throws Exception {
        File requiredDataFile = new File("really-important.data");
        byte[] data = new byte[0];
        data = FileUtils.readFileToByteArray(requiredDataFile);

        System.out.println("Read some data: " + Arrays.toString(data));
    }

    @Test
    public void assumeNoExceptionExample() {
        File requiredDataFile = new File("really-important.data");
        byte[] data = new byte[0];
        try {
            data = FileUtils.readFileToByteArray(requiredDataFile);
        } catch (IOException e) {
            // if something is required for the test, we can't continue the test without it so just quietly move on
            // NOTE: the documentation says the default JUnit runner treats this as an Ignore but Eclipse shows pass
            assumeNoException(e);
        }

        System.out.println("Read some data: " + Arrays.toString(data));
    }

    @Test
    public void assumeNotNullFailureExample() throws Exception {
        Connection dbConnection = getConnection();

        PreparedStatement statement = dbConnection.prepareStatement("select username from users");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(0));
        }
    }

    @Test
    public void assumeNotNullExample() throws Exception {
        Connection dbConnection = getConnection();
        // if something is required for the test, we can't continue the test without it so just quietly move on
        // NOTE: the documentation says the default JUnit runner treats this as an Ignore but Eclipse shows pass
        assumeNotNull(dbConnection);

        PreparedStatement statement = dbConnection.prepareStatement("select username from users");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(0));
        }
    }

    // NOTE: Assume also has a boolean check available as assumeTrue(boolean)
    // NOTE: Assume also has a Hamcrest matcher available for use as assumeThat(Matcher)

    private static Connection getConnection() {
        // in real code this would do something, but here we return null just to prove a point
        return null;
    }

}
