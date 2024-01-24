package com.example.javagroupproject1.dao;

import com.example.javagroupproject1.data.Category;
import com.example.javagroupproject1.data.IngredientName;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class IngredientNameDao extends BaseDaoImpl<IngredientName, Long> {

    protected IngredientNameDao(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, IngredientName.class);
    }
}
