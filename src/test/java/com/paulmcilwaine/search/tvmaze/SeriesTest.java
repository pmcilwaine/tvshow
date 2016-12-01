package com.paulmcilwaine.search.tvmaze;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paulmcilwaine.http.Request;
import com.paulmcilwaine.http.Response;
import com.paulmcilwaine.model.SeriesInterface;
import com.paulmcilwaine.search.tvmaze.datatype.SeriesCollection;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SeriesTest {
    @Test
    public void initialise() {
        new Series(
            mock(Request.class),
            mock(ObjectMapper.class)
        );
    }

    @Test
    public void findByName() throws Exception {
        Request requestMock = mock(Request.class);
        ObjectMapper objectMapperMock = mock(ObjectMapper.class);
        Response responseMock = mock(Response.class);

        SeriesCollection seriesCollection = new SeriesCollection();
        seriesCollection.setSeries(new com.paulmcilwaine.search.tvmaze.datatype.Series());

        SeriesCollection[] seriesCollections = {seriesCollection};

        when(responseMock.getBody()).thenReturn("");

        when(requestMock.execute(any())).thenReturn(responseMock);
        when(objectMapperMock.readValue(
            eq(""),
            eq(com.paulmcilwaine.search.tvmaze.datatype.SeriesCollection[].class)
        )).thenReturn(seriesCollections);

        Series series = new Series(requestMock, objectMapperMock);

        assertThat(
            series.findByName("10"),
            instanceOf(SeriesInterface.class)
        );
    }
}
