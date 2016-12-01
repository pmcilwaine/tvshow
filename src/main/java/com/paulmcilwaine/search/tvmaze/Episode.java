package com.paulmcilwaine.search.tvmaze;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paulmcilwaine.http.Request;
import com.paulmcilwaine.http.Response;
import com.paulmcilwaine.http.URIBuilder;
import com.paulmcilwaine.http.URIBuilderInterface;
import com.paulmcilwaine.model.EpisodeInterface;
import com.paulmcilwaine.search.EpisodeSearchInterface;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Episode implements EpisodeSearchInterface {
    private ObjectMapper mapper;
    private Request request;
    private final String SEARCH_URL = "http://api.tvmaze.com/shows/%s/episodes";

    public Episode(Request request, ObjectMapper mapper) {
        this.mapper = mapper;
        this.request = request;
    }

    private URIBuilderInterface generateUri(String id) {
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setMethod("GET");
        uriBuilder.setUrl(String.format(SEARCH_URL, id));

        return uriBuilder;
    }

    private com.paulmcilwaine.search.tvmaze.datatype.Episode[] retrieveEpisodes(Response response) {
        com.paulmcilwaine.search.tvmaze.datatype.Episode[] episodes = {};

        try {
            episodes = mapper.readValue(
                response.getBody(),
                com.paulmcilwaine.search.tvmaze.datatype.Episode[].class
            );
        } catch (IOException e) {
        }

        return episodes;
    }

    private Date parseDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
        }

        return null;
    }

    private List<EpisodeInterface> generateEpisodes(com.paulmcilwaine.search.tvmaze.datatype.Episode[] episodes) {
        ArrayList<EpisodeInterface> episodeList = new ArrayList<EpisodeInterface>();

        for (com.paulmcilwaine.search.tvmaze.datatype.Episode episode : episodes) {
            com.paulmcilwaine.model.Episode episodeModel = new com.paulmcilwaine.model.Episode();
            episodeModel.setId(episode.getId());
            episodeModel.setName(episode.getName());
            episodeModel.setDescription(episode.getSummary());
            episodeModel.setNumber(episode.getNumber());
            episodeModel.setAirDate(parseDate(episode.getAirdate()));

            episodeList.add(episodeModel);
        }

        return episodeList;
    }

    @Override
    public List<EpisodeInterface> findById(String id) {
        Response response = request.execute(generateUri(id));
        com.paulmcilwaine.search.tvmaze.datatype.Episode[] episodes = retrieveEpisodes(response);

        return generateEpisodes(episodes);
    }
}
