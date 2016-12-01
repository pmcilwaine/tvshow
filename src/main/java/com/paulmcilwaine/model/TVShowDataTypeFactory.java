package com.paulmcilwaine.model;

public interface TVShowDataTypeFactory {
    AbstractSeriesData getSeries();
    AbstractEpisodeData getEpisode();
    AbstractSeasonData getSeason();
}
