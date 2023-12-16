package com.example.javagroupproject1.data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "nutrients")
public class Nutrients {
    //region Constant Fields

    private static final int PROTEIN_CALORIES_PER_GRAM = 4;
    private static final int FAT_CALORIES_PER_GRAM = 9;
    private static final int CARB_CALORIES_PER_GRAM = 4;

    //endregion

    //region Private Fields

    @DatabaseField(useGetSet = true, generatedId = true)
    private int ID;

    @DatabaseField(useGetSet = true)
    private int proteinGrams;

    @DatabaseField(useGetSet = true)
    private int fatGrams;

    @DatabaseField(useGetSet = true)
    private int carbGrams;

    //endregion

    public Nutrients() {
    }


    //region Public Properties

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getProteinGrams() {
        return proteinGrams;
    }

    public void setProteinGrams(int proteinGrams) {
        this.proteinGrams = proteinGrams;
    }

    public int getFatGrams() {
        return fatGrams;
    }

    public void setFatGrams(int fatGrams) {
        this.fatGrams = fatGrams;
    }

    public int getCarbGrams() {
        return carbGrams;
    }

    public void setCarbGrams(int carbGrams) {
        this.carbGrams = carbGrams;
    }

    //endregion

    //region Public Methods

    public int calories()
    {
        int sum =
                PROTEIN_CALORIES_PER_GRAM * proteinGrams +
                FAT_CALORIES_PER_GRAM * fatGrams +
                CARB_CALORIES_PER_GRAM * carbGrams;
        return sum;
    }

    public int caloriesPerGram()
    {
        int sum = proteinGrams + fatGrams + carbGrams;
        return calories() / sum;
    }

    //endregion
}
