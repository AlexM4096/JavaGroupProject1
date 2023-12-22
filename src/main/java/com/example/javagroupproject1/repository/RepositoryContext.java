package com.example.javagroupproject1.repository;

import com.example.javagroupproject1.dao.DaoContext;
import com.example.javagroupproject1.data.IngredientType;
import com.example.javagroupproject1.data.Recipe;

public class RepositoryContext {
    public final IRepository<Recipe> recipes;
    public final IRepository<IngredientType> ingredientTypes;

    public RepositoryContext(DaoContext daoContext){
        recipes = new RecipeRepository(daoContext);
        ingredientTypes = new IngredientTypeRepository(daoContext);
    }
}
