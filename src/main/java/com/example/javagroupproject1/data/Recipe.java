package com.example.javagroupproject1.data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@DatabaseTable(tableName = "recipes")
public class Recipe {
    //region Fields

    @DatabaseField(useGetSet = true, generatedId = true)
    private int ID;

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

    @DatabaseField(useGetSet = true, foreign = true)
    private Nutrients nutrients;
    
    public final Collection<Image> images = new ArrayList<>();

    public final List<Ingredient> ingredients = new ArrayList<>();

    public final List<Step> steps = new ArrayList<>();

    //endregion

    //region Constructors

    public Recipe(){

    }

    public Recipe(
            String name,
            String category,
            int difficulty,
            int cookingTimeMinutes,
            int grams,
            Nutrients nutrients
    ) {
        this.name = name;
        this.category = category;
        this.difficulty = difficulty;
        this.cookingTimeMinutes = cookingTimeMinutes;
        this.grams = grams;
        this.nutrients = nutrients;
    }

    //endregion

    //region Properties

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
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

    public Nutrients getNutrients() {
        return nutrients;
    }

    public void setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
    }

    //endregion
}
