package com.paulmcilwaine.model.tvmaze;

import com.paulmcilwaine.model.AbstractEpisodeData;

public class EpisodeData extends AbstractEpisodeData {
    @Override
    public String getIdFieldName() {
        return "tvmazeId";
    }
}
