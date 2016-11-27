package com.paulmcilwaine.http;

public abstract class HttpClient {
    private HttpFactory httpFactory;

    public HttpClient(HttpFactory httpFactory) {
        this.httpFactory = httpFactory;
    }

    abstract public void setUrl(String url);
    abstract public void setMethod(String url);
    abstract public Response execute();
}
