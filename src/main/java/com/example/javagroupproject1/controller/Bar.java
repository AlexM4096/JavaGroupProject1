package com.example.javagroupproject1.controller;

import com.example.javagroupproject1.MyApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Bar extends BorderPane {

    @FXML
    private void addRecipeFromWebSiteClick(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://eda.ru/recepty"));
    }

    @FXML
    private void goToMainClick(ActionEvent event) {
        SceneController.instance.activateScene("main");
    }

    @FXML
    private void addRecipeByYourselfClick(ActionEvent event) {
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
