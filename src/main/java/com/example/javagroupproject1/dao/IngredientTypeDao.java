package com.example.javagroupproject1.dao;

import com.example.javagroupproject1.data.IngredientType;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class IngredientTypeDao extends BaseDaoImpl<IngredientType, Long> {
    public IngredientTypeDao(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, IngredientType.class);
    }
}
