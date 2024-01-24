package com.example.javagroupproject1.dao;

import com.example.javagroupproject1.data.Category;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class CategoryDao extends BaseDaoImpl<Category, Long> {
    public CategoryDao(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Category.class);
    }
}
