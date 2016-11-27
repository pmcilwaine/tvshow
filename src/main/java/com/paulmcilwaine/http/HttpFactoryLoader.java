package com.paulmcilwaine.http;

public class HttpFactoryLoader {
    public static HttpFactory createFromString(String className)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (HttpFactory)Class.forName(className).newInstance();
    }
}
