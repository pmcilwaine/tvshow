package com.paulmcilwaine.search.tvmaze;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paulmcilwaine.http.Request;
import com.paulmcilwaine.http.Response;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EpisodeTest {
    @Test
    public void initialise() {
        new Episode(
            mock(Request.class),
            mock(ObjectMapper.class)
        );
    }

    @Test
    public void findById() throws Exception {
        Request requestMock = mock(Request.class);
        ObjectMapper objectMapperMock = mock(ObjectMapper.class);
        Response responseMock = mock(Response.class);

        com.paulmcilwaine.search.tvmaze.datatype.Episode episodeDataType = new com.paulmcilwaine.search.tvmaze.datatype.Episode();
        episodeDataType.setId("12");
        episodeDataType.setName("Name");
        episodeDataType.setSummary("Summary");
        episodeDataType.setNumber(1);
        episodeDataType.setAirdate("2000-01-01");
        com.paulmcilwaine.search.tvmaze.datatype.Episode[] episodes = {episodeDataType};

        when(responseMock.getBody()).thenReturn("");

        when(requestMock.execute(any())).thenReturn(responseMock);
        when(objectMapperMock.readValue(
            eq(""),
            eq(com.paulmcilwaine.search.tvmaze.datatype.Episode[].class)
        )).thenReturn(episodes);

        Episode episode = new Episode(
            requestMock,
            objectMapperMock
        );

        assertEquals(episode.findById("10").size(), 1);
    }

    @Test
    public void findByIdWithNoResults() throws IOException {
        Request requestMock = mock(Request.class);
        ObjectMapper objectMapperMock = mock(ObjectMapper.class);
        Response responseMock = mock(Response.class);

        com.paulmcilwaine.search.tvmaze.datatype.Episode[] episodes = {};

        when(responseMock.getBody()).thenReturn("");

        when(requestMock.execute(any())).thenReturn(responseMock);
        when(objectMapperMock.readValue(
            eq(""),
            eq(com.paulmcilwaine.search.tvmaze.datatype.Episode[].class)
        )).thenReturn(episodes);

        Episode episode = new Episode(
            requestMock,
            objectMapperMock
        );

        assertEquals(0, episode.findById("10").size());
    }
}
