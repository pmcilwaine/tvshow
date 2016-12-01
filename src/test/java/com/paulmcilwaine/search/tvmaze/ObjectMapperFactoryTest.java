package com.paulmcilwaine.search.tvmaze;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class ObjectMapperFactoryTest {
    @Test
    public void create() {
        assertThat(
            ObjectMapperFactory.create(),
            instanceOf(ObjectMapper.class)
        );
    }
}
