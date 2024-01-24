package com.example.javagroupproject1.dao;

import com.example.javagroupproject1.data.Recipe;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecipeDao extends BaseDaoImpl<Recipe, Long> {
    protected RecipeDao(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Recipe.class);
    }

    public List<Recipe> sortAndFiltrate(
            List<String> categories,
            List<String> ingredients,
            String time,
            String favorite) {


        Iterable<Recipe> recipes;
        try {
            recipes = queryForAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        List<Recipe> newRecipes = new ArrayList<>();

        recipes.forEach(x -> {
            switch (favorite){
                case "Только избранные":
                    if (x.getIsFavorite() == true) newRecipes.add(x);
                    break;

                case "Только не избранные":
                    if (x.getIsFavorite() != true) newRecipes.add(x);
                    break;

                default:
                    newRecipes.add(x);
                    break;
            }
        });

        switch (time){
            case "По возрастанию":
                newRecipes.sort((x1, x2) -> {
                    return x2.getCookingTimeMinutes() - x1.getCookingTimeMinutes();
                });
                break;

            case "По убыванию":
                newRecipes.sort((x1, x2) -> {
                    return x1.getCookingTimeMinutes() - x2.getCookingTimeMinutes();
                });
                break;

            default:
                break;
        }

        return newRecipes;

    }
}
