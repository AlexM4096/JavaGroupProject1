package com.example.javagroupproject1.repository;

public class RepositoryHolder {
    public final RecipeRepository recipes;

    public RepositoryHolder(){
        recipes = new RecipeRepository()
    }
}
