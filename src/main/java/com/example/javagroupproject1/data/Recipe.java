package com.example.javagroupproject1.data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import javafx.scene.image.Image;

import java.util.Collection;
import java.util.List;

@DatabaseTable(tableName = "recipes")
public class Recipe implements IEntity {
    //region Fields

    @DatabaseField(useGetSet = true, generatedId = true)
    private long ID;

    @DatabaseField(useGetSet = true)
    private String name;

    @DatabaseField(useGetSet = true)
    private String category;

    @DatabaseField(useGetSet = true)
    private int difficulty;

    @DatabaseField(useGetSet = true)
    private int cookingTimeMinutes;

    @DatabaseField(useGetSet = true)
    private int grams;

    @DatabaseField(useGetSet = true)
    private int portions;
    
    private Collection<Image> images;

    private List<Ingredient> ingredients;

    private List<Step> steps;

    //endregion

    //region Constructors

    public Recipe(){

    }

    //endregion

    //region Properties

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getCookingTimeMinutes() {
        return cookingTimeMinutes;
    }

    public void setCookingTimeMinutes(int cookingTimeMinutes){
        this.cookingTimeMinutes = cookingTimeMinutes;
    }

    public int getGrams() {
        return grams;
    }

    public void setGrams(int grams) {
        this.grams = grams;
    }

    public int getPortions() {
        return portions;
    }

    public void setPortions(int portions) {
        this.portions = portions;
    }

    public Collection<Image> getImages() {
        return images;
    }

    public void setImages(Collection<Image> images) {
        this.images = images;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    //endregion
}
