package com.paulmcilwaine.search.tvmaze;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paulmcilwaine.http.Request;
import com.paulmcilwaine.http.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SeasonTest {
    @Test
    public void initialise() {
        new Season(
            mock(Request.class),
            mock(ObjectMapper.class)
        );
    }

    @Test
    public void findById() throws Exception {
        Request requestMock = mock(Request.class);
        ObjectMapper objectMapperMock = mock(ObjectMapper.class);
        Response responseMock = mock(Response.class);

        com.paulmcilwaine.search.tvmaze.datatype.Season seasonData = new com.paulmcilwaine.search.tvmaze.datatype.Season();

        com.paulmcilwaine.search.tvmaze.datatype.Season[] seasons = {seasonData};

        when(responseMock.getBody()).thenReturn("");
        when(requestMock.execute(any())).thenReturn(responseMock);
        when(objectMapperMock.readValue(
            eq(""),
            eq(com.paulmcilwaine.search.tvmaze.datatype.Season[].class)
        )).thenReturn(seasons);

        Season season = new Season(requestMock, objectMapperMock);
        assertEquals(1, season.findById("10").size());
    }

}
