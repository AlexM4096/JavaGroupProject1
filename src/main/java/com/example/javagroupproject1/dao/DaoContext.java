package com.example.javagroupproject1.dao;

import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class DaoContext {
    public final RecipeDao recipeDao;
    public final IngredientDao ingredientDao;
    public final StepDao stepDao;
    public final RecipeIngredientDao recipeIngredientDao;
    public final StepImageDao stepImageDao;
    public final IngredientTypeDao ingredientTypeDao;

    public DaoContext(ConnectionSource connectionSource) throws SQLException{
        recipeDao = new RecipeDao(connectionSource);
        ingredientDao = new IngredientDao(connectionSource);
        stepDao = new StepDao(connectionSource);
        recipeIngredientDao = new RecipeIngredientDao(connectionSource);
        stepImageDao = new StepImageDao(connectionSource);
        ingredientTypeDao = new IngredientTypeDao(connectionSource);

    }
}
