package com.example.javagroupproject1.repository;

import com.example.javagroupproject1.data.Recipe;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class RecipeRepository {
    private static final String URL = "jdbc:sqlite:D:/Apps/IntelliJ IDEA/IdeaProjects/JavaGroupProject1/src/main/resources/com/example/javagroupproject1/test.db:recipe";

    private final Dao<Recipe, Long> dao;

    public RecipeRepository(){
        try (ConnectionSource connectionSource = new JdbcConnectionSource(URL)) {
            dao = DaoManager.createDao(connectionSource, Recipe.class);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
