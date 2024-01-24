package com.example.javagroupproject1.controller;

import com.example.javagroupproject1.Database;
import com.example.javagroupproject1.data.Recipe;
import com.example.javagroupproject1.repository.RepositoryContext;
import com.example.javagroupproject1.tools.Prefs;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RecipeController implements Initializable {

    @FXML
    private TextField name;

    @FXML
    private void saveClick(){
        recipe.setName(name.getText());

        rc.recipes.addOrUpdate(recipe);

        MainController.getInstance().update();
        SceneController.instance.activateScene("main");
    }

    @FXML
    private void closeClick(){
        MainController.getInstance().update();
        SceneController.instance.activateScene("main");
    }

    private static RecipeController instance;
    public static RecipeController getInstance(){
        return instance;
    }

    private RepositoryContext rc;

    private Recipe recipe;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instance = this;

        rc = Database.INSTANCE.repositoryContext;;
    }

    public void update(){
        recipe = (Recipe) Prefs.getInstance().read("recipe");
        name.setText(recipe.getName());
    }
}
