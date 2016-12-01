package com.paulmcilwaine.model;

import java.util.Date;

public interface SeasonInterface {
    String getId();
    void setId(String id);

    String getName();
    void setName(String name);

    String getImage();
    void setImage(String image);

    Date getStartDate();
    void setStartDate(Date startDate);

    Date getEndDate();
    void setEndDate(Date endDate);
}
