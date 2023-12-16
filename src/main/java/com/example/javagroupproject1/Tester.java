package com.example.javagroupproject1;

import com.example.javagroupproject1.data.Recipe;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Tester {
    public static void main(String[] args) throws Exception{
        String databaseUrl = "jdbc:sqlite:D:/Apps/IntelliJ IDEA/IdeaProjects/JavaGroupProject1/src/main/resources/com/example/javagroupproject1/test.db:recipe";
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        Connection connection = DriverManager.getConnection(databaseUrl);

        Dao<Recipe, String> recipeDao = DaoManager.createDao(connectionSource, Recipe.class);
        TableUtils.createTableIfNotExists(connectionSource, Recipe.class);

        Recipe recipe = new Recipe();
        recipe.setName("testdsf");

        recipeDao.isTableExists();

        connectionSource.close();
    }
}
