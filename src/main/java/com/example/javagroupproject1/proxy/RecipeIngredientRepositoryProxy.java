package com.example.javagroupproject1.proxy;

import com.example.javagroupproject1.data.Ingredient;
import com.example.javagroupproject1.data.Recipe;
import com.example.javagroupproject1.data.RecipeIngredient;
import com.example.javagroupproject1.repository.IRecipeIngredientRepository;

import java.util.List;

public class RecipeIngredientRepositoryProxy extends RepositoryProxy<RecipeIngredient, IRecipeIngredientRepository>
        implements IRecipeIngredientRepository {
    public RecipeIngredientRepositoryProxy(IRecipeIngredientRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Ingredient> ingredientsFromRecipe(Recipe recipe) {
        long recipeID = recipe.getID();

        List<Ingredient> ingredients = map.values().stream().
                filter(t -> t.getRecipe().getID() == recipeID).
                map(t -> t.getIngredient()).toList();

        return ingredients;
    }

    @Override
    public Iterable<Recipe> recipesFromIngredient(Ingredient ingredient) {
        return null;
    }
}
