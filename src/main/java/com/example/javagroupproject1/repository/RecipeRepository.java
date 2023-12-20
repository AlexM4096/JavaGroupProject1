package com.example.javagroupproject1.repository;

import com.example.javagroupproject1.dao.DaoContext;
import com.example.javagroupproject1.data.Ingredient;
import com.example.javagroupproject1.data.Recipe;
import com.example.javagroupproject1.data.RecipeIngredient;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;

public class RecipeRepository extends RepositoryBase implements IRepository<Recipe> {
    protected RecipeRepository(DaoContext dc) {
        super(dc);
    }

    @Override
    public Iterable<Recipe> GetAll() {
        try {
            return dc.recipeDao.queryForAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Recipe GetByID(long id) {
        try {
            Recipe recipe = dc.recipeDao.queryForId(id);

            QueryBuilder<RecipeIngredient, Long> recipeIngredientQB = dc.recipeIngredientDao.queryBuilder();
            recipeIngredientQB.where().eq(RecipeIngredient.RECIPE_ID_FIELD_NAME, recipe.getID());

            QueryBuilder<Ingredient, Long> ingredientQB = dc.ingredientDao.queryBuilder();
            ingredientQB.join(recipeIngredientQB);

            recipe.setIngredients(ingredientQB.query());

            return recipe;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void Add(Recipe entity) {
        try {
            dc.recipeDao.createIfNotExists(entity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void Update(Recipe entity) {
        try {
            dc.recipeDao.update(entity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void Delete(Recipe entity) {
        try {
            dc.recipeDao.delete(entity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
