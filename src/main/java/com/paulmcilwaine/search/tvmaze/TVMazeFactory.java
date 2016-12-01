package com.paulmcilwaine.search.tvmaze;

import com.paulmcilwaine.http.Request;
import com.paulmcilwaine.search.EpisodeSearchInterface;
import com.paulmcilwaine.search.SeasonSearchInterface;
import com.paulmcilwaine.search.SeriesSearchInterface;
import com.paulmcilwaine.search.TVSearchInterface;

public class TVMazeFactory implements TVSearchInterface {
    Request request;

    public TVMazeFactory(Request request) {
        this.request = request;
    }

    @Override
    public SeriesSearchInterface getSeriesSearch() {
        return new Series(request, ObjectMapperFactory.create());
    }

    @Override
    public SeasonSearchInterface getSeasonSearch() {
        return new Season(request, ObjectMapperFactory.create());
    }

    @Override
    public EpisodeSearchInterface getEpisodeSearch() {
        return new Episode(request, ObjectMapperFactory.create());
    }
}
