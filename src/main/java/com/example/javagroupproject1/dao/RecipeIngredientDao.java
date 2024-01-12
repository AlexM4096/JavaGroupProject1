package com.example.javagroupproject1.dao;

import com.example.javagroupproject1.data.RecipeIngredient;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class RecipeIngredientDao extends BaseDaoImpl<RecipeIngredient, Long> {
    public RecipeIngredientDao(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, RecipeIngredient.class);
    }
}
