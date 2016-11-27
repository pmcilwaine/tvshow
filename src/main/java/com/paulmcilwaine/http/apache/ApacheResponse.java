package com.paulmcilwaine.http.apache;

import com.paulmcilwaine.http.Response;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.*;

public class ApacheResponse implements Response {
    private CloseableHttpResponse response;

    public ApacheResponse(CloseableHttpResponse response) {
        this.response = response;
    }

    @Override
    public String getBody() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            InputStream inputStream = response.getEntity().getContent();

            while (inputStream.available() > 0) {
                stringBuilder.append((char)inputStream.read());
            }

            return stringBuilder.toString();
        } catch (IOException e) {
            // just catch for now, no throwing. Update interface if we want to throw.
        }

        return null;
    }

    @Override
    public int getStatus() {
        return response.getStatusLine().getStatusCode();
    }
}
