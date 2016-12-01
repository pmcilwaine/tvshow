package com.paulmcilwaine.search.tvmaze;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.paulmcilwaine.http.Request;
import com.paulmcilwaine.http.Response;
import com.paulmcilwaine.http.URIBuilder;
import com.paulmcilwaine.http.URIBuilderInterface;
import com.paulmcilwaine.model.SeasonInterface;
import com.paulmcilwaine.search.SeasonSearchInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Season implements SeasonSearchInterface {
    private ObjectMapper mapper;
    private Request request;
    private final String SEARCH_URL = "http://api.tvmaze.com/shows/%s/seasons";

    public Season(Request request, ObjectMapper mapper) {
        this.mapper = mapper;
        this.request = request;
    }

    private com.paulmcilwaine.search.tvmaze.datatype.Season[] retrieveSeasons(Response response) {
        com.paulmcilwaine.search.tvmaze.datatype.Season[] seasons = {};
        try {
            seasons = mapper.readValue(response.getBody(), com.paulmcilwaine.search.tvmaze.datatype.Season[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return seasons;
    }

    private List<SeasonInterface> generateSeasons(com.paulmcilwaine.search.tvmaze.datatype.Season[] seasons) {
        ArrayList<SeasonInterface> seasonList = new ArrayList<SeasonInterface>();

        for (com.paulmcilwaine.search.tvmaze.datatype.Season season : seasons) {
            com.paulmcilwaine.model.Season seasonModel = new com.paulmcilwaine.model.Season();
            seasonModel.setId(season.getId());
            seasonModel.setName(season.getNumber());

            seasonList.add(seasonModel);
        }

        return seasonList;
    }

    private URIBuilderInterface generateUri(String id) {
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setMethod("GET");
        uriBuilder.setUrl(String.format(SEARCH_URL, id));

        return uriBuilder;
    }

    @Override
    public List<SeasonInterface> findById(String id) {
        Response response = request.execute(generateUri(id));
        com.paulmcilwaine.search.tvmaze.datatype.Season[] seasons = retrieveSeasons(response);

        if (seasons.length == 0) {
            return null;
        }

        return generateSeasons(seasons);
    }
}
