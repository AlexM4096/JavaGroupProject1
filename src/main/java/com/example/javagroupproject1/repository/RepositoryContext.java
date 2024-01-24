package com.example.javagroupproject1.repository;

import com.example.javagroupproject1.dao.DaoContext;

public class RepositoryContext {
    public final IRecipeRepository recipeRepository;
    public final IIngredientNameRepository ingredientNameRepository;

    public RepositoryContext(DaoContext daoContext){
        recipeRepository = new RecipeRepository(daoContext);
        ingredientNameRepository = new IngredientNameRepository(daoContext);
    }
}
