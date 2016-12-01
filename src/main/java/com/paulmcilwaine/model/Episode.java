package com.paulmcilwaine.model;

import java.util.Date;

public class Episode implements EpisodeInterface {
    private String id;
    private String name;
    private String image;
    private String description;
    private int number;
    private Date airDate;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public Date getAirDate() {
        return airDate;
    }

    @Override
    public void setAirDate(Date airDate) {
        this.airDate = airDate;
    }
}
