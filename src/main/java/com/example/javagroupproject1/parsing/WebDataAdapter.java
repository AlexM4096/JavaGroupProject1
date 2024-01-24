package com.example.javagroupproject1.parsing;

import com.example.javagroupproject1.data.Ingredient;
import com.example.javagroupproject1.data.Recipe;
import com.example.javagroupproject1.tools.SerializableImage;
import com.example.javagroupproject1.tools.TimeConverter;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class WebDataAdapter {

    public AdaptedWebData adapt(WebData webData){
        Recipe recipe = new Recipe();

        recipe.setName(webData.getTitle());
        recipe.setCategory(webData.getCategory());
        recipe.setPortionsAmount(webData.getPortions());
        recipe.setCookingTimeMinutes(TimeConverter.convertToMinutes(webData.getTime()));

        var images = webData.getImageUrls();
        if (!images.isEmpty()){
            recipe.setSerializableImage(new SerializableImage(new Image(images.getFirst())));
        }

        List<Ingredient> ingredients = new ArrayList<>();
        for (var a: webData.getIngredients()){
            Ingredient ingredient = new Ingredient();
            ingredient.setName(a);
            ingredients.add(ingredient);
        }

        return new AdaptedWebData(
                recipe,
                ingredients);
    }
}
