package com.paulmcilwaine.model;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class EpisodeTest {
    @Test
    public void initialise() throws ParseException {
        Episode episode = new Episode();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date airDate = dateFormat.parse("2000-01-01");

        episode.setId("12");
        episode.setName("Name");
        episode.setImage("image/path");
        episode.setNumber(1);
        episode.setDescription("Description");
        episode.setAirDate(airDate);

        assertEquals("12", episode.getId());
        assertEquals("Name", episode.getName());
        assertEquals("image/path", episode.getImage());
        assertEquals(1, episode.getNumber());
        assertEquals("Description", episode.getDescription());
        assertEquals(airDate, episode.getAirDate());
    }
}
