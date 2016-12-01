package com.paulmcilwaine.model.tvmaze;

import org.junit.Test;

import static org.junit.Assert.*;

public class EpisodeDataTest {
    @Test
    public void initialise() {
        EpisodeData episodeData = new EpisodeData();
        assertEquals("tvmazeId", episodeData.getIdFieldName());
        assertEquals("name", episodeData.getNameField());
        assertEquals("description", episodeData.getDescriptionNameField());
        assertEquals("image", episodeData.getImageNameField());
        assertEquals("number", episodeData.getNumberNameField());
        assertEquals("path", episodeData.getPathNameField());
    }
}
