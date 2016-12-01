package com.paulmcilwaine.search.tvmaze;

import com.paulmcilwaine.http.Request;
import com.paulmcilwaine.search.EpisodeSearchInterface;
import com.paulmcilwaine.search.SeasonSearchInterface;
import com.paulmcilwaine.search.SeriesSearchInterface;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class TVMazeFactoryTest {
    @Test
    public void initialise() {
        new TVMazeFactory(mock(Request.class));
    }

    @Test
    public void getSeriesSearch() throws Exception {
        TVMazeFactory tvMazeFactory = new TVMazeFactory(mock(Request.class));
        assertThat(
            tvMazeFactory.getSeriesSearch(),
            instanceOf(SeriesSearchInterface.class)
        );
    }

    @Test
    public void getSeasonSearch() throws Exception {
        TVMazeFactory tvMazeFactory = new TVMazeFactory(mock(Request.class));
        assertThat(
            tvMazeFactory.getSeasonSearch(),
            instanceOf(SeasonSearchInterface.class)
        );
    }

    @Test
    public void getEpisodeSearch() throws Exception {
        TVMazeFactory tvMazeFactory = new TVMazeFactory(mock(Request.class));
        assertThat(
            tvMazeFactory.getEpisodeSearch(),
            instanceOf(EpisodeSearchInterface.class)
        );
    }
}
