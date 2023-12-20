package com.example.javagroupproject1.dao;

import com.example.javagroupproject1.data.Ingredient;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class IngredientDao extends BaseDaoImpl<Ingredient, Long> {

    protected IngredientDao(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Ingredient.class);
    }
}
