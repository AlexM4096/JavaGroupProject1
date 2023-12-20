package com.example.javagroupproject1.dao;

import com.example.javagroupproject1.data.Ingredient;
import com.j256.ormlite.dao.BaseDaoImpl;

import java.sql.SQLException;

public class IngredientDao extends BaseDaoImpl<Ingredient, Long> {
    protected IngredientDao(Class<Ingredient> dataClass) throws SQLException {
        super(dataClass);
    }
}
