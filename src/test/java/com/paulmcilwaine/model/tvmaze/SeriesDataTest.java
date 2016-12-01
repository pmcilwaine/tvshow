package com.paulmcilwaine.model.tvmaze;

import org.junit.Test;

import static org.junit.Assert.*;

public class SeriesDataTest {
    @Test
    public void initialise() {
        SeriesData seriesData = new SeriesData();
        assertEquals("tvmazeId", seriesData.getIdNameField());
        assertEquals("name", seriesData.getNameField());
        assertEquals("description", seriesData.getDescriptionNameField());
        assertEquals("image", seriesData.getImageNameField());
        assertEquals("number", seriesData.getNumberNameField());
        assertEquals("path", seriesData.getPathNameField());
    }
}
