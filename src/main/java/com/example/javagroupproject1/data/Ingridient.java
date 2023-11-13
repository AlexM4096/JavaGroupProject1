package com.example.javagroupproject1.data;

public class Ingridient
{
    public String name;
    public int grams;
    public Nutrients nutrients;

    public int calories()
    {
        float k = (float) grams / nutrients.grams;
        int n = (int) (k * nutrients.calories);
        return n;
    }
}
