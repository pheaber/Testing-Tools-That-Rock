package org.ojug.mockito;

import static org.mockito.Mockito.verify;

import java.sql.Connection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SimpleInjectedMockito {

    @Mock
    private Connection mockConnection;

    @Test
    public void preparedStatement() throws Exception {
        this.mockConnection.prepareStatement("select name from users");

        verify(this.mockConnection).prepareStatement("select name from users");
    }

}
