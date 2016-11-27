package com.paulmcilwaine.http.apache;

import com.paulmcilwaine.http.Connection;
import com.paulmcilwaine.http.Request;
import com.paulmcilwaine.http.Response;
import org.apache.http.impl.client.HttpClients;

public class HttpFactory implements com.paulmcilwaine.http.HttpFactory {
    @Override
    public Connection getConnection() {
        return new com.paulmcilwaine.http.apache.Connection(
            HttpClients.createDefault()
        );
    }

    @Override
    public Request getRequest() {
        return null;
    }

    @Override
    public Response getResponse() {
        return null;
    }
}
