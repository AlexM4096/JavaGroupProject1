package com.example.javagroupproject1.adapter;

import com.example.javagroupproject1.data.Recipe;
import com.example.javagroupproject1.parsing.WebData;

public class WebDataAdapter {

    public Recipe getRecipe(WebData webData){
        Recipe recipe = new Recipe();

        recipe.setName(webData.getTitle());
        recipe.setCategory(webData.getCategory());
        recipe.setPortionsAmount(webData.getPortions());

        return recipe;
    }
}
