package com.paulmcilwaine.http;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class RequestFactoryLoaderTest {
    @Test(expected = Exception.class)
    public void createInvalidFactory() throws Exception {
        new RequestFactoryLoader().createFromString("badFactory");
    }

    @Test
    public void createFactory() throws Exception {
        assertThat(
            new RequestFactoryLoader().createFromString("com.paulmcilwaine.http.apache.RequestFactory"),
            instanceOf(RequestFactoryInterface.class)
        );
    }
}