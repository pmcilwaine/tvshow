package com.paulmcilwaine.http;

public class ConnectionCloseException extends Exception {
    public ConnectionCloseException(String message) {
        super(message);
    }
}
