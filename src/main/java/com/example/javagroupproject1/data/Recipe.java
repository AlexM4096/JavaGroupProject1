package com.example.javagroupproject1.data;

import java.util.ArrayList;
import java.util.List;

public class Recipe
{
    public String name;
    public String category;
    public int cookingTime;
    public Nutrients nutrients;
    public int grams;

    public List<Ingridient> ingridients = new ArrayList<>();
    public List<Step> steps = new ArrayList<>();

    public int calories()
    {
        int sum = 0;
        for (Ingridient ingridient: ingridients)
        {
            sum += ingridient.calories();
        }

        float k = (float) grams / nutrients.grams;
        return (int) (sum * k);
    }
}
