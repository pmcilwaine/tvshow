package com.paulmcilwaine.http.apache;

import com.paulmcilwaine.http.Request;
import com.paulmcilwaine.http.RequestFactoryInterface;
import org.apache.http.impl.client.HttpClients;

public class RequestFactory implements RequestFactoryInterface {
    @Override
    public Request create() {
        return new ApacheRequest(HttpClients.createDefault());
    }
}
