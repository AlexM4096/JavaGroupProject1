package com.example.javagroupproject1.data;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Step {
    //region Fields

    private String description;
    public final List<Image> images = new ArrayList<>();

    //endregion

    //region Properties

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //endregion
}
