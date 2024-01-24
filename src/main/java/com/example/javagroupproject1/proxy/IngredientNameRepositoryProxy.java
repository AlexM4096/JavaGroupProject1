package com.example.javagroupproject1.proxy;

import com.example.javagroupproject1.data.IngredientName;
import com.example.javagroupproject1.repository.IIngredientNameRepository;

public class IngredientNameRepositoryProxy extends RepositoryProxy<IngredientName, IIngredientNameRepository> implements IIngredientNameRepository{
    public IngredientNameRepositoryProxy(IIngredientNameRepository repository) {
        super(repository);
    }
}
