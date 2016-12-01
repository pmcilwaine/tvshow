package com.paulmcilwaine.model;

public abstract class AbstractSeriesData {
    public abstract String getIdNameField();

    public String getNumberNameField() {
        return "number";
    }

    public String getNameField() {
        return "name";
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
