package com.example.javagroupproject1.data;

public class Ingredient {
    //region Fields

    private String name;
    private int grams;
    private Nutrients nutrients;

    //endregion

    //region Properties

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    //region Methods

    public int calories()
    {
        return nutrients.caloriesPerGram() * grams;
    }

    //endregion
}
