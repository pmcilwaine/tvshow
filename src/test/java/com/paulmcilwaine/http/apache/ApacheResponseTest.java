package com.paulmcilwaine.http.apache;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ApacheResponseTest {
    @Test
    public void initialise() {
        CloseableHttpResponse closeableHttpResponse = mock(CloseableHttpResponse.class);
        new ApacheResponse(closeableHttpResponse);
    }

    @Test
    public void getBodyHasString() throws IOException {
        CloseableHttpResponse closeableHttpResponse = mock(CloseableHttpResponse.class);
        HttpEntity httpEntity = mock(HttpEntity.class);

        when(httpEntity.getContent()).thenReturn(new ByteArrayInputStream(
            "Hello World".getBytes()
        ));
        when(closeableHttpResponse.getEntity()).thenReturn(httpEntity);

        ApacheResponse response = new ApacheResponse(closeableHttpResponse);
        assertEquals("Hello World", response.getBody());
    }

    @Test
    public void getBodyReturnsNullDueToIOException() throws IOException {
        CloseableHttpResponse closeableHttpResponse = mock(CloseableHttpResponse.class);
        HttpEntity httpEntity = mock(HttpEntity.class);

        doThrow(new IOException()).when(httpEntity).getContent();
        when(closeableHttpResponse.getEntity()).thenReturn(httpEntity);

        ApacheResponse response = new ApacheResponse(closeableHttpResponse);
        assertEquals(null, response.getBody());
    }

    @Test
    public void got200Status() {
        CloseableHttpResponse closeableHttpResponse = mock(CloseableHttpResponse.class);

        StatusLine statusLineMock = mock(StatusLine.class);
        when(statusLineMock.getStatusCode()).thenReturn(200);

        when(closeableHttpResponse.getStatusLine()).thenReturn(statusLineMock);

        ApacheResponse response = new ApacheResponse(closeableHttpResponse);
        assertEquals(200, response.getStatus());
    }
}