package com.paulmcilwaine.http;

import org.junit.Test;

import static org.junit.Assert.*;

public class URIBuilderTest {
    @Test
    public void url() {
        URIBuilderInterface uriBuilder = new URIBuilder();
        uriBuilder.setUrl("url");
        assertEquals("url", uriBuilder.getUrl());
    }

    @Test
    public void method() {
        URIBuilderInterface uriBuilder = new URIBuilder();
        uriBuilder.setMethod("GET");
        assertEquals("GET", uriBuilder.getMethod());
    }
}