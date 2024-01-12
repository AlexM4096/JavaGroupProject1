package com.example.javagroupproject1.repository;

import com.example.javagroupproject1.data.Ingredient;
import com.example.javagroupproject1.data.Recipe;
import com.example.javagroupproject1.data.RecipeIngredient;

public interface IRecipeIngredientRepository extends IRepository<RecipeIngredient> {
    public Iterable<Ingredient> ingredientsFromRecipe(Recipe recipe);
    public Iterable<Recipe> recipesFromIngredient(Ingredient ingredient);
}
