package com.paulmcilwaine.http;

public interface HttpFactory {
    public Connection getConnection();
    public Request getRequest();
    public Response getResponse();
}
