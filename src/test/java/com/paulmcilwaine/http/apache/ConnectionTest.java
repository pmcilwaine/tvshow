package com.paulmcilwaine.http.apache;

import com.paulmcilwaine.http.ConnectionCloseException;
import com.paulmcilwaine.http.Request;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class ConnectionTest {
    private Connection connection;
    private Request requestMock;
    private CloseableHttpClient clientMock;

    @Before
    public void setup() {
        clientMock = mock(CloseableHttpClient.class);
        connection = new Connection(clientMock);

        requestMock = mock(Request.class);
    }

    @Test
    public void connectionNotOpen() {
        assertFalse(connection.isOpen());
    }

    @Test
    public void connectionIsOpen() {
        connection.open(requestMock);
        assertTrue(connection.isOpen());
    }

    @Test
    public void openConnectionAndRequestMade() {
        connection.open(requestMock);
    }

    @Test
    public void connectionClosed() throws ConnectionCloseException {
        connection.open(requestMock);
        connection.close();
    }

    @Test(expected = ConnectionCloseException.class)
    public void connectionNotClosedOnException() throws IOException, ConnectionCloseException {
        doThrow(new IOException()).when(clientMock).close();

        connection.open(requestMock);
        connection.close();
    }
}