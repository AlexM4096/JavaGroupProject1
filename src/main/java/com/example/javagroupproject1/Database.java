package com.example.javagroupproject1;

import com.example.javagroupproject1.dao.DaoContext;
import com.example.javagroupproject1.data.*;
import com.example.javagroupproject1.repository.RepositoryContext;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class Database {
    public static final Database INSTANCE = new Database();
    private static final String DATABASE_URL = "jdbc:h2:mem:my-db";

    public final RepositoryContext repositoryContext;

    public Database() {
        try {
            ConnectionSource connectionSource = new JdbcConnectionSource(DATABASE_URL);
            DaoContext daoContext = new DaoContext(connectionSource);

            createTables(connectionSource);

            repositoryContext = new RepositoryContext(daoContext);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void createTables(ConnectionSource connectionSource) throws SQLException{
        TableUtils.createTableIfNotExists(connectionSource, Recipe.class);
        TableUtils.createTableIfNotExists(connectionSource, Ingredient.class);
        TableUtils.createTableIfNotExists(connectionSource, Step.class);
        TableUtils.createTableIfNotExists(connectionSource, RecipeIngredient.class);
        TableUtils.createTableIfNotExists(connectionSource, StepImage.class);
        TableUtils.createTableIfNotExists(connectionSource, IngredientType.class);
    }
}
