package com.example.javagroupproject1.proxy;

import com.example.javagroupproject1.data.Recipe;
import com.example.javagroupproject1.repository.IRecipeRepository;

public class RecipeRepositoryProxy extends RepositoryProxy<Recipe, IRecipeRepository>
        implements IRecipeRepository {
    public RecipeRepositoryProxy(IRecipeRepository repository) {
        super(repository);
    }
}
