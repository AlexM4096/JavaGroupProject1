package com.example.javagroupproject1.data;

public class Nutrients
{
    private static final int PROTEIN_CALORIES_PER_GRAM = 4;
    private static final int FAT_CALORIES_PER_GRAM = 9;
    private static final int CARB_CALORIES_PER_GRAM = 4;

    public final int proteinGrams;
    public final int fatGrams;
    public final int carbGrams;

    public final int grams;
    public final int calories;


    public Nutrients(int proteinGrams, int fatGrams, int carbGrams)
    {
        this.proteinGrams = proteinGrams;
        this.carbGrams = carbGrams;
        this.fatGrams = fatGrams;

        grams = proteinGrams + carbGrams + fatGrams;

        int proteinCalories = proteinGrams * PROTEIN_CALORIES_PER_GRAM;
        int fatCalories = fatGrams * FAT_CALORIES_PER_GRAM;
        int carbCalories = carbGrams * CARB_CALORIES_PER_GRAM;

        calories = proteinCalories + fatCalories + carbCalories;
    }
}
