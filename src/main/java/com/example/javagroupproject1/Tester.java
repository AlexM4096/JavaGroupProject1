package com.example.javagroupproject1;

import com.example.javagroupproject1.data.Ingredient;
import com.example.javagroupproject1.data.Recipe;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.util.List;

public class Tester {
    public static void main(String[] args) throws Exception{
        String databaseUrl = "jdbc:sqlite:D:/Apps/IntelliJ IDEA/IdeaProjects/JavaGroupProject1/src/main/resources/com/example/javagroupproject1/identifier.sqlite";
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
        Dao<Recipe, String> recipeDao = DaoManager.createDao(connectionSource, Recipe.class);
        TableUtils.createTable(connectionSource, Recipe.class);

        Recipe recipe0 = new Recipe();
        recipe0.setName("test");

        Recipe recipe1 = new Recipe();
        recipe1.setName("test");

        Recipe recipe2 = new Recipe();
        recipe2.setName("test");


        recipeDao.create(recipe0);
        recipeDao.create(recipe1);
        recipeDao.create(recipe2);

        QueryBuilder<Recipe, String> queryBuilder = recipeDao.queryBuilder();
        queryBuilder.where().eq("name", "test");
        PreparedQuery<Recipe> preparedQuery = queryBuilder.prepare();
        List<Recipe> accountList = recipeDao.query(preparedQuery);
        System.out.println(accountList.size());
    }
}
