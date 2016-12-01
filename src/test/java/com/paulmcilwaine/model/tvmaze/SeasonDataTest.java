package com.paulmcilwaine.model.tvmaze;

import org.junit.Test;

import static org.junit.Assert.*;

public class SeasonDataTest {
    @Test
    public void initialise() {
        SeasonData seasonData = new SeasonData();
        assertEquals("tvmazeId", seasonData.getIdNameField());
        assertEquals("name", seasonData.getNameField());
    }
}
