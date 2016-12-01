package com.paulmcilwaine.model.tvmaze;

import com.paulmcilwaine.model.AbstractSeasonData;

public class SeasonData extends AbstractSeasonData {
    @Override
    public String getIdNameField() {
        return "tvmazeId";
    }
}
