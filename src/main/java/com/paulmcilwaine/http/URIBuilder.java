package com.paulmcilwaine.http;

public class URIBuilder implements URIBuilderInterface {
    private String url;
    private String method;

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void setMethod(String method) {
        this.method = method;
    }
}
