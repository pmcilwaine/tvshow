package com.paulmcilwaine.search;

public interface TVSearchInterface {
    SeriesSearchInterface getSeriesSearch();
    SeasonSearchInterface getSeasonSearch();
    EpisodeSearchInterface getEpisodeSearch();
}
