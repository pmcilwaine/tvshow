package com.paulmcilwaine.model;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class SeasonTest {
    @Test
    public void initialiseModel() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = dateFormat.parse("2000-01-01");
        Date endDate = dateFormat.parse("2001-01-01");

        Season season = new Season();
        season.setId("12");
        season.setName("1");
        season.setStartDate(startDate);
        season.setEndDate(endDate);
        season.setImage("image/path");

        assertEquals("12", season.getId());
        assertEquals("1", season.getName());
        assertEquals(startDate, season.getStartDate());
        assertEquals(endDate, season.getEndDate());
        assertEquals("image/path", season.getImage());
    }
}
