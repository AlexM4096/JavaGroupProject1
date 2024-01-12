package com.example.javagroupproject1.data;

import com.example.javagroupproject1.repository.IEntity;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "recipes-ingredients")
public class RecipeIngredient implements IEntity {

    public static final String RECIPE_ID_FIELD_NAME = "recipeID";
    public static final String INGREDIENT_ID_FIELD_NAME = "ingredientID";

    @DatabaseField(useGetSet = true, generatedId = true)
    private long ID;

    @DatabaseField(useGetSet = true, foreign = true, columnName = RECIPE_ID_FIELD_NAME)
    private Recipe recipe;

    @DatabaseField(useGetSet = true, foreign = true, columnName = INGREDIENT_ID_FIELD_NAME)
    private Ingredient ingredient;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}
