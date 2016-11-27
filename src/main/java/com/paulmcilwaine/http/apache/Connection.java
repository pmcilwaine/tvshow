package com.paulmcilwaine.http.apache;

import com.paulmcilwaine.http.ConnectionCloseException;
import com.paulmcilwaine.http.Request;
import com.paulmcilwaine.http.Response;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;

public class Connection implements com.paulmcilwaine.http.Connection {
    private CloseableHttpClient client;
    private boolean isOpen = false;

    public Connection(CloseableHttpClient client) {
        this.client = client;
    }

    @Override
    public Response open(Request request) {
        isOpen = true;

        return null;
    }

    @Override
    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public void close() throws ConnectionCloseException {
        try {
            client.close();
            isOpen = false;
        } catch (IOException e) {
            throw new ConnectionCloseException(e.getMessage());
        }
    }
}
