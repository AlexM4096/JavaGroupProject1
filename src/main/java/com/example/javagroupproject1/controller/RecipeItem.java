package com.example.javagroupproject1.controller;

import com.example.javagroupproject1.MyApplication;
import com.example.javagroupproject1.data.Recipe;
import com.example.javagroupproject1.tools.TimeConverter;
import com.example.javagroupproject1.tools.Prefs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class RecipeItem extends SplitPane {
    private Recipe recipe;

    @FXML
    private ImageView image;

    @FXML
    private Label name;

    @FXML
    private Label cookingTime;

    @FXML
    private Label category;

    @FXML
    private CheckBox isFavorite;

    @FXML
    private void click(ActionEvent event){
        Prefs.getInstance().createOrUpdate("recipe", recipe);
        RecipeController.getInstance().update();
        SceneController.instance.activateScene("recipe");
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;


        name.setText(recipe.getName());
        cookingTime.setText(TimeConverter.convertFromMinutes(recipe.getCookingTimeMinutes()));
        category.setText(recipe.getCategory());
        image.setImage(recipe.getImage());

        isFavorite.setSelected(recipe.getIsFavorite());
        isFavorite.setOnAction(e -> {
            recipe.setIsFavorite(isFavorite.isSelected());
        });
    }

    public RecipeItem(){
        loadFxml();
    }

    public RecipeItem(Recipe recipe){
        this();
        setRecipe(recipe);
    }

    private void loadFxml() {
        FXMLLoader fxmlLoader = new FXMLLoader(MyApplication.class.getResource("views/recipe-item.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
