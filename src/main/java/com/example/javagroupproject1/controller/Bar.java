package com.example.javagroupproject1.controller;

import com.example.javagroupproject1.MyApplication;
import com.example.javagroupproject1.data.Category;
import com.example.javagroupproject1.data.Recipe;
import com.example.javagroupproject1.tools.Prefs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URISyntaxException;

public class Bar extends BorderPane {

    @FXML
    private void addRecipeFromWebSiteClick(ActionEvent event) throws URISyntaxException, IOException {
        SceneController.instance.activateScene("web");
    }

    @FXML
    private void goToMainClick(ActionEvent event) {
        SceneController.instance.activateScene("main");
    }

    @FXML
    private void addRecipeByYourselfClick(ActionEvent event) {
        Prefs.getInstance().createOrUpdate("recipe", new Recipe());
        RecipeController.getInstance().update();
        SceneController.instance.activateScene("recipe");
    }

    public Bar() {
        loadFxml();
    }

    private void loadFxml() {
        FXMLLoader fxmlLoader = new FXMLLoader(MyApplication.class.getResource("views/bar.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
