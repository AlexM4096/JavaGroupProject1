package com.example.javagroupproject1.dao;

import com.example.javagroupproject1.data.Recipe;
import com.j256.ormlite.dao.BaseDaoImpl;

import java.sql.SQLException;

public class RecipeDao extends BaseDaoImpl<Recipe, Long> {
    protected RecipeDao(Class<Recipe> dataClass) throws SQLException {
        super(dataClass);
    }
}
