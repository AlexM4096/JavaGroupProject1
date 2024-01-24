package com.example.javagroupproject1.parsing;

import com.example.javagroupproject1.data.IngredientName;
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
        recipe.setImage(new Image(webData.getImageUrls().getLast()));
        recipe.setPortionsAmount(webData.getPortions());
        recipe.setCategoryName(webData.getCategory());
        recipe.setCookingTimeMinutes(TimeConverter.convertToMinutes(webData.getTime()));

        var images = webData.getImageUrls();
        if (!images.isEmpty()){
            recipe.setSerializableImage(new SerializableImage(new Image(images.getFirst())));
        }

        List<IngredientName> ingredientNames = new ArrayList<>();
        for (var a: webData.getIngredients()){
            IngredientName ingredientName = new IngredientName();
            ingredientName.setName(a.split("[0123456789]", 2)[0]);
            ingredientNames.add(ingredientName);
        }

        return new AdaptedWebData(
                recipe,
                ingredientNames);
    }
}
