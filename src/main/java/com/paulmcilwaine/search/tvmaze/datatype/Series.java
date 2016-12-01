package com.paulmcilwaine.search.tvmaze.datatype;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Series {
    private String id;
    private String name;
    private String premiered;
    private String summary;
    private Map<String, String> image;

    public Series() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPremiered() {
        return premiered;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setPremiered(String premiered) {
        this.premiered = premiered;
    }

    public String getSummary() {
        return summary;
    }

    public Map<String, String> getImage() {
        return image;
    }

    public void setImage(Map<String, String> image) {
        this.image = image;
    }
}
