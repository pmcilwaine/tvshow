package com.paulmcilwaine.model.tvmaze;

import com.paulmcilwaine.model.AbstractSeriesData;

public class SeriesData extends AbstractSeriesData {
    @Override
    public String getIdNameField() {
        return "tvmazeId";
    }
}
