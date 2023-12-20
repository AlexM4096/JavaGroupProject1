package com.example.javagroupproject1.data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

@DatabaseTable(tableName = "steps")
public class Step {
    //region Fields

    @DatabaseField(useGetSet = true, generatedId = true)
    private int ID;

    @DatabaseField(useGetSet = true)
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
//endregion
}
