package com.example.javagroupproject1.parsing;

import com.example.javagroupproject1.data.Ingredient;
import com.example.javagroupproject1.data.Recipe;

import java.util.List;

public record AdaptedWebData(Recipe recipe, List<Ingredient> ingredients) {
}
