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

    public static final boolean CLEAR_START = false;
    private static final String DATABASE_URL = "jdbc:sqlite:my-db.sqlite";

    public final RepositoryContext repositoryContext;

    public Database() {
        try {
            ConnectionSource connectionSource = new JdbcConnectionSource(DATABASE_URL);

            if (CLEAR_START)
                clearTables(connectionSource);
            else
                createTables(connectionSource);

            DaoContext daoContext = new DaoContext(connectionSource);
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

    public void clearTables(ConnectionSource connectionSource) throws SQLException{
        TableUtils.clearTable(connectionSource, Recipe.class);
        TableUtils.clearTable(connectionSource, Ingredient.class);
        TableUtils.clearTable(connectionSource, Step.class);
        TableUtils.clearTable(connectionSource, RecipeIngredient.class);
        TableUtils.clearTable(connectionSource, StepImage.class);
        TableUtils.clearTable(connectionSource, IngredientType.class);
    }
}
