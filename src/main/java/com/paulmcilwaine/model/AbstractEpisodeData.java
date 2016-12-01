package com.paulmcilwaine.model;

public abstract class AbstractEpisodeData {
    abstract public String getIdFieldName();

    public String getNameField() {
        return "name";
    }

    public String getNumberNameField() {
        return "number";
    }

    public String getImageNameField() {
        return "image";
    }

    public String getDescriptionNameField() {
        return "description";
    }

    public String getPathNameField() {
        return "path";
    }
}
