package com.example.javagroupproject1.proxy;

import com.example.javagroupproject1.data.Recipe;
import com.example.javagroupproject1.repository.IRepository;

public class RecipeProxy extends RepositoryProxy<Recipe> {
    public RecipeProxy(IRepository<Recipe> repository) {
        super(repository);
    }
}
