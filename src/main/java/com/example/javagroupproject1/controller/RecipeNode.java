package com.example.javagroupproject1.controller;

import com.example.javagroupproject1.MyApplication;
import com.example.javagroupproject1.data.Recipe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class RecipeNode extends Parent {
    private Recipe recipe;

    @FXML
    private ImageView image;

    @FXML
    private Label name;

    @FXML
    private Label cookingTime;

    @FXML
    private Label category;

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;

        image.setImage(recipe.getImage().getImage());
        name.setText(recipe.getName());
        cookingTime.setText(getCookingTime());
        category.setText(recipe.getCategory());
    }

    private String getCookingTime() {
        int cookingTimeMinutes = recipe.getCookingTimeMinutes();
        String string = "";

        int cookingHours = cookingTimeMinutes / 60;
        if (cookingHours > 0){
            String cookingHoursWord;

            switch (cookingHours){
                case 1:
                    cookingHoursWord = "час";
                    break;
                case 2, 3, 4:
                    cookingHoursWord = "часа";
                    break;
                default:
                    cookingHoursWord = "часов";
                    break;
            }
            string += cookingHours + " " + cookingHoursWord + " ";
        }

        int cookingMinutes = cookingTimeMinutes % 60;
        if (cookingMinutes> 0){
            String cookingMinutesWord;

            switch (cookingHours){
                case 1:
                    cookingMinutesWord = "минута";
                    break;
                case 2, 3, 4:
                    cookingMinutesWord = "минуты";
                    break;
                default:
                    cookingMinutesWord = "минут";
                    break;
            }
            string += cookingHours + " " + cookingMinutesWord;
        }

        return string;
    }

    public RecipeNode(Recipe recipe){
        loadFxml();
        setRecipe(recipe);
    }

    private void loadFxml() {
        FXMLLoader fxmlLoader = new FXMLLoader(MyApplication.class.getResource("views/recipe-item.fxml"));
        fxmlLoader.setController(this);

        try {
            this.getChildren().add(fxmlLoader.load());
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
