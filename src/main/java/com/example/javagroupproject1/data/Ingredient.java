package com.example.javagroupproject1.data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "ingredients")
public class Ingredient {
    //region Fields

    @DatabaseField(useGetSet = true, generatedId = true)
    private int ID;

    @DatabaseField(useGetSet = true)
    private String name;

    @DatabaseField(useGetSet = true)
    private int grams;

    @DatabaseField(useGetSet = true, foreign = true)
    private Nutrients nutrients;

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
