package com.example.javagroupproject1.repository;

import com.example.javagroupproject1.data.Recipe;

import java.util.ArrayList;
import java.util.List;

public class TempRepository implements IRepository<Recipe> {
    private final List<Recipe> recipes;

    public TempRepository()
    {
        recipes = new ArrayList<>();
    }


    @Override
    public void Insert(Recipe entity)
    {
        recipes.add(entity);
    }

    @Override
    public Recipe Find(int id)
    {
        return recipes.get(id);
    }

    @Override
    public void Update(Recipe entity)
    {

    }

    @Override
    public void Delete(Recipe entity)
    {
        recipes.remove(entity);
    }
}