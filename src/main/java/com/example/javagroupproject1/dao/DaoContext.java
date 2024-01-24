package com.example.javagroupproject1.dao;

import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class DaoContext {
    public final RecipeDao recipeDao;
    public final IngredientNameDao ingredientNameDao;
    public final CategoryDao categoryDao;

    public DaoContext(ConnectionSource connectionSource) throws SQLException{
        recipeDao = new RecipeDao(connectionSource);
        ingredientNameDao = new IngredientNameDao(connectionSource);
        categoryDao = new CategoryDao(connectionSource);
    }
}
