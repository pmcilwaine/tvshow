package com.paulmcilwaine.model;

import java.util.Date;

public interface EpisodeInterface {
    String getId();
    void setId(String id);

    String getName();
    void setName(String name);

    String getImage();
    void setImage(String image);

    String getDescription();
    void setDescription(String description);

    int getNumber();
    void setNumber(int number);

    Date getAirDate();
    void setAirDate(Date airDate);
}
