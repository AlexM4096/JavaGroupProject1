package com.example.javagroupproject1.repository;

import com.example.javagroupproject1.dao.DaoContext;
import com.example.javagroupproject1.data.Ingredient;
import com.example.javagroupproject1.data.Recipe;
import com.example.javagroupproject1.data.RecipeIngredient;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;

import java.sql.SQLException;

public class RecipeIngredientRepository extends RepositoryBase implements IRecipeIngredientRepository {

    private final PreparedQuery<Ingredient> ingredientsForRecipeQuery;
    private final PreparedQuery<Recipe> recipesForIngredientQuery;

    public RecipeIngredientRepository(DaoContext dc) throws SQLException {
        super(dc);

        ingredientsForRecipeQuery = makeIngredientsForRecipeQuery();
        recipesForIngredientQuery = makeRecipesForIngredientQuery();
    }

    @Override
    public Iterable<Ingredient> ingredientsFromRecipe(Recipe recipe) {
        try {
            ingredientsForRecipeQuery.setArgumentHolderValue(0, recipe);
            return dc.ingredientDao.query(ingredientsForRecipeQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterable<Recipe> recipesFromIngredient(Ingredient ingredient) {
        try {
            recipesForIngredientQuery.setArgumentHolderValue(0, ingredient);
            return dc.recipeDao.query(recipesForIngredientQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private PreparedQuery<Ingredient> makeIngredientsForRecipeQuery() throws SQLException {
        QueryBuilder<RecipeIngredient, Long> recipeIngredientQB = dc.recipeIngredientDao.queryBuilder();

        recipeIngredientQB.selectColumns(RecipeIngredient.INGREDIENT_ID_FIELD_NAME);
        SelectArg selectArg = new SelectArg();
        recipeIngredientQB.where().eq(RecipeIngredient.RECIPE_ID_FIELD_NAME, selectArg);

        QueryBuilder<Ingredient, Long> ingredientQB = dc.ingredientDao.queryBuilder();
        ingredientQB.where().in(RecipeIngredient.RECIPE_ID_FIELD_NAME, recipeIngredientQB);

        return ingredientQB.prepare();
    }

    private PreparedQuery<Recipe> makeRecipesForIngredientQuery() throws SQLException {
        QueryBuilder<RecipeIngredient, Long> recipeIngredientQB = dc.recipeIngredientDao.queryBuilder();

        recipeIngredientQB.selectColumns(RecipeIngredient.RECIPE_ID_FIELD_NAME);
        SelectArg selectArg = new SelectArg();
        recipeIngredientQB.where().eq(RecipeIngredient.INGREDIENT_ID_FIELD_NAME, selectArg);

        QueryBuilder<Recipe, Long> recipeQB = dc.recipeDao.queryBuilder();
        recipeQB.where().in(RecipeIngredient.INGREDIENT_ID_FIELD_NAME, recipeIngredientQB);

        return recipeQB.prepare();
    }

    @Override
    public Iterable<RecipeIngredient> getAll() {
        try {
            return dc.recipeIngredientDao.queryForAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public RecipeIngredient getByID(long id) {
        try {
            return dc.recipeIngredientDao.queryForId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(RecipeIngredient entity) {
        try {
            dc.recipeIngredientDao.createIfNotExists(entity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(RecipeIngredient entity) {
        try {
            dc.recipeIngredientDao.update(entity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(RecipeIngredient entity) {
        try {
            dc.recipeIngredientDao.update(entity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
