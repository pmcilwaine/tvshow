package com.paulmcilwaine.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SeriesTest {
    @Test
    public void initialise() {
        Series series = new Series();
        series.setId("12");
        series.setName("Name");
        series.setDescription("Description");
        series.setPath("/path/to/file");

        assertEquals("12", series.getId());
        assertEquals("Name", series.getName());
        assertEquals("Description", series.getDescription());
        assertEquals("/path/to/file", series.getPath());
    }
}
