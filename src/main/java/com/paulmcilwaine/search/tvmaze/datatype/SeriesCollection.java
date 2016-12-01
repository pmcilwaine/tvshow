package com.paulmcilwaine.search.tvmaze.datatype;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SeriesCollection {
    @JsonProperty("show")
    private Series series;

    public SeriesCollection() {

    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }
}
