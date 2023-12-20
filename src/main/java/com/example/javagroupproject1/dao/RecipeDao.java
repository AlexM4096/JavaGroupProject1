package com.example.javagroupproject1.dao;

import com.example.javagroupproject1.data.Recipe;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class RecipeDao extends BaseDaoImpl<Recipe, Long> {
    protected RecipeDao(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Recipe.class);
    }
}
