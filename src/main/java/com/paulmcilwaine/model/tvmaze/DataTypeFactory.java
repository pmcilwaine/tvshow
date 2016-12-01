package com.paulmcilwaine.model.tvmaze;

import com.paulmcilwaine.model.AbstractEpisodeData;
import com.paulmcilwaine.model.AbstractSeasonData;
import com.paulmcilwaine.model.AbstractSeriesData;
import com.paulmcilwaine.model.TVShowDataTypeFactory;

public class DataTypeFactory implements TVShowDataTypeFactory {
    @Override
    public AbstractSeriesData getSeries() {
        return new SeriesData();
    }

    @Override
    public AbstractEpisodeData getEpisode() {
        return new EpisodeData();
    }

    @Override
    public AbstractSeasonData getSeason() {
        return new SeasonData();
    }
}
