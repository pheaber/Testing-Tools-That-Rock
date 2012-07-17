package org.ojug.mockito;

import static org.mockito.Mockito.verify;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SimpleInitMockito {

    @Mock
    private Connection mockConnection;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void preparedStatement() throws Exception {
        this.mockConnection.prepareStatement("select name from users");

        verify(this.mockConnection).prepareStatement("select name from users");
    }

}
