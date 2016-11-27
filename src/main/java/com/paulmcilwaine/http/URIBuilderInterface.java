package com.paulmcilwaine.http;

public interface URIBuilderInterface {
    String getUrl();
    String getMethod();

    void setUrl(String url);
    void setMethod(String method);
}
