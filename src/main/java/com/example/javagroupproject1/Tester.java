package com.example.javagroupproject1;

import com.example.javagroupproject1.data.Recipe;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class Tester {
    public static void main(String[] args) throws Exception{
        String databaseUrl = "jdbc:sqlite:my.db:recipe";
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        Dao<Recipe, Long> recipeDao = DaoManager.createDao(connectionSource, Recipe.class);
        TableUtils.createTableIfNotExists(connectionSource, Recipe.class);

        

        connectionSource.close();
    }
}
