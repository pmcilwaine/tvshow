package com.paulmcilwaine.http;

public interface Request {
    Response execute(URIBuilderInterface uriBuilder);
}
