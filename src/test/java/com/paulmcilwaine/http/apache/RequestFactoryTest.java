package com.paulmcilwaine.http.apache;

import org.junit.Test;

import static org.junit.Assert.*;

public class RequestFactoryTest {
    @Test
    public void create() {
        RequestFactory requestFactory = new RequestFactory();
        assertEquals(requestFactory.create().getClass(), ApacheRequest.class);
    }
}