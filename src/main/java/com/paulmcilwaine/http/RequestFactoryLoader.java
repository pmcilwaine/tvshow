package com.paulmcilwaine.http;

public class RequestFactoryLoader {
    public RequestFactoryInterface createFromString(String className)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (RequestFactoryInterface)Class.forName(className).newInstance();
    }
}
