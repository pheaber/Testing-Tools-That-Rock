package org.ojug.mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.sql.Connection;

import org.junit.Test;

public class SimpleMockito {

    private final Connection mockConnection = mock(Connection.class);

    @Test
    public void preparedStatement() throws Exception {
        this.mockConnection.prepareStatement("select name from users");

        verify(this.mockConnection).prepareStatement("select name from users");
    }

}
