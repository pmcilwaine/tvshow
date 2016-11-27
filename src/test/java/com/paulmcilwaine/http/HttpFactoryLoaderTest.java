package com.paulmcilwaine.http;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class HttpFactoryLoaderTest {
    @Test(expected = Exception.class)
    public void createInvalidFactory() throws Exception {
        HttpFactoryLoader.createFromString("badFactory");
    }

    @Test
    public void createFactory() throws Exception {
        assertThat(
            HttpFactoryLoader.createFromString("com.paulmcilwaine.http.apache.HttpFactory"),
            instanceOf(HttpFactory.class)
        );
        assertThat(
            HttpFactoryLoader.createFromString("com.paulmcilwaine.http.apache.HttpFactory"),
            instanceOf(com.paulmcilwaine.http.apache.HttpFactory.class)
        );
    }
}