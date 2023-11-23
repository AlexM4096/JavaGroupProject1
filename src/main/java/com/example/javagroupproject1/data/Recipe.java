package com.example.javagroupproject1.data;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    //region Fields

    private String name;
    private String category;
    private int difficulty;
    private int cookingTimeMinutes;
    private int grams;
    private Nutrients nutrients;
    public final List<Ingredient> ingredients = new ArrayList<Ingredient>();
    public final List<Step> steps = new ArrayList<>();

    //endregion

    //region Properties

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
