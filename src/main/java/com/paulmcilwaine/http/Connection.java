package com.paulmcilwaine.http;

public interface Connection {
    Response open(Request request);
    boolean isOpen();
    void close() throws ConnectionCloseException;
}
