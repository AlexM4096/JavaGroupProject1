package com.example.javagroupproject1.dao;

import com.j256.ormlite.jdbc.JdbcConnectionSource;

import java.sql.SQLException;

public class DaoContext {
    public final RecipeDao recipeDao;
    public final IngredientDao ingredientDao;
    public final StepDao stepDao;
    public final RecipeIngredientDao recipeIngredientDao;

    public DaoContext() throws SQLException{
        recipeDao = new RecipeDao(new JdbcConnectionSource(""));
        ingredientDao = new IngredientDao(new JdbcConnectionSource(""));
        stepDao = new StepDao(new JdbcConnectionSource(""));
        recipeIngredientDao = new RecipeIngredientDao(new JdbcConnectionSource(""));
    }
}
