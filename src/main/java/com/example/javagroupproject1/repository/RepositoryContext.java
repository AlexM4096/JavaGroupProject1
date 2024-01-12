package com.example.javagroupproject1.repository;

import com.example.javagroupproject1.dao.DaoContext;
import com.example.javagroupproject1.proxy.RecipeRepositoryProxy;

public class RepositoryContext {
    public final IRecipeRepository recipes;

    public RepositoryContext(DaoContext daoContext){
        recipes = new RecipeRepositoryProxy(new RecipeRepository(daoContext));
    }
}
