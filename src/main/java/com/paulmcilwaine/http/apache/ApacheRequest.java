package com.paulmcilwaine.http.apache;

import com.paulmcilwaine.http.Request;
import com.paulmcilwaine.http.Response;
import com.paulmcilwaine.http.URIBuilderInterface;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;

public class ApacheRequest implements Request {
    private CloseableHttpClient httpClient;

    public ApacheRequest(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    private HttpUriRequest getHttpRequestMethod(URIBuilderInterface uriBuilder) {
        return new HttpGet(uriBuilder.getUrl());
    }

    @Override
    public Response execute(URIBuilderInterface uriBuilder) {
        try {
            return new ApacheResponse(
                httpClient.execute(getHttpRequestMethod(uriBuilder))
            );
        } catch (IOException e) {
        }

        return null;
    }
}
