package com.paulmcilwaine.http.apache;

import com.paulmcilwaine.http.Request;
import com.paulmcilwaine.http.Response;
import com.paulmcilwaine.http.URIBuilderInterface;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ApacheRequestTest {
    @Test
    public void initialise() {
        new ApacheRequest(mock(CloseableHttpClient.class));
    }

    @Test
    public void execute() throws IOException {
        URIBuilderInterface uriBuilderMock = mock(URIBuilderInterface.class);
        CloseableHttpResponse httpResponseMock = mock(CloseableHttpResponse.class);
        CloseableHttpClient httpMock = mock(CloseableHttpClient.class);

        when(uriBuilderMock.getMethod()).thenReturn("GET");
        when(uriBuilderMock.getUrl()).thenReturn("uri");

        when(httpMock.execute(any(HttpGet.class))).thenReturn(httpResponseMock);

        Request request = new ApacheRequest(httpMock);
        assertThat(request.execute(uriBuilderMock), instanceOf(Response.class));

        verify(uriBuilderMock).getUrl();
    }

    @Test
    public void executeWithInvalidMethod() throws IOException {
        URIBuilderInterface uriBuilderMock = mock(URIBuilderInterface.class);
        CloseableHttpClient httpMock = mock(CloseableHttpClient.class);

        when(uriBuilderMock.getUrl()).thenReturn("");
        doThrow(new IOException()).when(httpMock).execute(any(HttpGet.class));

        Request request = new ApacheRequest(httpMock);
        assertSame(request.execute(uriBuilderMock), null);
    }
}