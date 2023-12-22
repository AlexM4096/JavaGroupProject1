package com.example.javagroupproject1.repository;

import com.example.javagroupproject1.dao.DaoContext;
import com.example.javagroupproject1.data.*;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

public class RecipeRepository extends Repository implements IRepository<Recipe> {
    public RecipeRepository(DaoContext dc) {
        super(dc);
    }

    @Override
    public Iterable<Recipe> getAll() {
        try {
            List<Recipe> recipes = dc.recipeDao.queryForAll();

            for (Recipe recipe: recipes) {
                setIngredients(recipe);
                setSteps(recipe);
            }

            return recipes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Recipe getByID(long id) {
        try {
            Recipe recipe = dc.recipeDao.queryForId(id);

            setIngredients(recipe);
            setSteps(recipe);

            return recipe;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Recipe entity) {
        try {
            dc.recipeDao.createIfNotExists(entity);

            dc.stepDao.create(entity.getSteps());
            dc.ingredientDao.create(entity.getIngredients());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Recipe entity) {
        try {
            dc.recipeDao.update(entity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Recipe entity) {
        try {
            dc.recipeDao.delete(entity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setIngredients(Recipe recipe) throws SQLException {
        QueryBuilder<RecipeIngredient, Long> recipeIngredientQB = dc.recipeIngredientDao.queryBuilder();
        recipeIngredientQB.where().eq(RecipeIngredient.RECIPE_ID_FIELD_NAME, recipe.getID());

        QueryBuilder<Ingredient, Long> ingredientQB = dc.ingredientDao.queryBuilder();
        ingredientQB.join(recipeIngredientQB);

        recipe.setIngredients(ingredientQB.query());
    }

    private void setSteps(Recipe recipe) throws SQLException{
        QueryBuilder<Step, Long> stepQB = dc.stepDao.queryBuilder();
        stepQB.where().eq(Step.RECIPE_ID_FIELD_NAME, recipe.getID());

        recipe.setSteps(stepQB.query());
    }
}
