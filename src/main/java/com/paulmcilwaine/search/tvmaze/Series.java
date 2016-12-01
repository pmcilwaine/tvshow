package com.paulmcilwaine.search.tvmaze;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paulmcilwaine.http.Request;
import com.paulmcilwaine.http.Response;
import com.paulmcilwaine.http.URIBuilder;
import com.paulmcilwaine.http.URIBuilderInterface;
import com.paulmcilwaine.model.SeriesInterface;
import com.paulmcilwaine.search.SeriesSearchInterface;
import com.paulmcilwaine.search.tvmaze.datatype.SeriesCollection;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Series implements SeriesSearchInterface {
    private ObjectMapper mapper;
    private Request request;
    private final String SEARCH_URL = "http://api.tvmaze.com/search/shows?q=";

    public Series(Request request, ObjectMapper mapper) {
        this.mapper = mapper;
        this.request = request;
    }

    private String encode(String name) {
        try {
            return URLEncoder.encode(name, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return name;
        }
    }

    private SeriesCollection[] retrieveSeries(Response response) {
        SeriesCollection[] seriesCollections = {};

        try {
            seriesCollections = mapper.readValue(
                response.getBody(),
                SeriesCollection[].class
            );
        } catch (IOException e) {
        }

        return seriesCollections;
    }

    private com.paulmcilwaine.model.Series generateSeries(
        com.paulmcilwaine.search.tvmaze.datatype.Series seriesResponse
    ) {
        com.paulmcilwaine.model.Series series = new com.paulmcilwaine.model.Series();
        series.setId(seriesResponse.getId());
        series.setName(seriesResponse.getName());
        series.setDescription(seriesResponse.getSummary());

        return series;
    }

    private URIBuilderInterface generateUri(String name) {
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setMethod("GET");
        uriBuilder.setUrl(SEARCH_URL + encode(name));

        return uriBuilder;
    }

    @Override
    public SeriesInterface findByName(String name) {
        Response response = request.execute(generateUri(name));
        SeriesCollection[] seriesCollections = retrieveSeries(response);

        if (seriesCollections.length == 0) {
            return null;
        }

        return generateSeries(seriesCollections[0].getSeries());
    }
}
