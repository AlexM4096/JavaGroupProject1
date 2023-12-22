package com.example.javagroupproject1.data;

import com.example.javagroupproject1.tools.SerializableImage;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

@DatabaseTable(tableName = "steps")
public class Step {

    public static final String RECIPE_ID_FIELD_NAME = "recipeID";

    //region Fields

    @DatabaseField(useGetSet = true, generatedId = true)
    private long ID;

    @DatabaseField(useGetSet = true, foreign = true, columnName = RECIPE_ID_FIELD_NAME)
    private Recipe recipe;

    @DatabaseField(useGetSet = true)
    private int stepNumber;

    @DatabaseField(useGetSet = true)
    private String description;

    private List<SerializableImage> images;

    //endregion

    //region Properties

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public List<SerializableImage> getImages() {
        return images;
    }

    public void setImages(List<SerializableImage> images) {
        this.images = images;
    }

    //endregion
}
