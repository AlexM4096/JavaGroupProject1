package com.example.javagroupproject1;

import com.example.javagroupproject1.data.Ingredient;
import com.example.javagroupproject1.data.IngredientType;
import com.example.javagroupproject1.data.Recipe;
import com.example.javagroupproject1.data.Step;
import com.example.javagroupproject1.tools.SerializableImage;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String[] args) throws Exception{
        IngredientType ingredientType1 = new IngredientType();
        ingredientType1.setName("Sugar");

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setType(ingredientType1);

        IngredientType ingredientType2 = new IngredientType();
        ingredientType2.setName("Flour");

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setType(ingredientType2);

        IngredientType ingredientType3 = new IngredientType();
        ingredientType3.setName("Flour");

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setType(ingredientType3);

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        ingredients.add(ingredient3);

        SerializableImage serializableImage1 = new SerializableImage();
        FileInputStream inputstream = new FileInputStream("C:\\Users\\trank\\IdeaProjects\\JavaGroupProject1\\src\\main\\resources\\com\\example\\javagroupproject1\\images\\bul.png");
        Image image1 = new Image(inputstream);
        serializableImage1.setImage(image1);

        List<SerializableImage> images = new ArrayList<>();
        images.add(serializableImage1);

        Step step1 = new Step();
        step1.setDescription("Step 1");
        step1.setImages(images);

        Step step2 = new Step();
        step2.setDescription("Step 2");

        List<Step> steps = new ArrayList<>();
        steps.add(step1);
//        steps.add(step2);

        Recipe recipe1 = new Recipe();
        recipe1.setName("Cake");
        recipe1.setIngredients(ingredients);
        recipe1.setSteps(steps);


        Database.INSTANCE.repositoryContext.recipes.add(recipe1);

        Iterable<Recipe> recipes = Database.INSTANCE.repositoryContext.recipes.getAll();

        for (Recipe recipe: recipes) {
            System.out.println(recipe.getName());
            for (Ingredient ingredient: recipe.getIngredients()) {
                System.out.println("    " + ingredient.getType().getName());
            }
            for (Step step: recipe.getSteps()) {
                System.out.println("    " + step.getDescription());
                System.out.println(step.getImages().size());
            }
        }

        System.out.println(Database.INSTANCE.repositoryContext.ingredientTypes.getAll());
    }
}
