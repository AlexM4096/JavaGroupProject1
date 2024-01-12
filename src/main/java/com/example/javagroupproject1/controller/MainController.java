package com.example.javagroupproject1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import org.controlsfx.control.CheckComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private CheckComboBox<String> category;

    @FXML
    private CheckComboBox<String> time;

    @FXML
    private CheckComboBox<String> hardness;

    @FXML
    private CheckComboBox<String> ingredient;

    @FXML
    private VBox vBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        category.getItems().addAll("1", "2");

//        for (int i =0; i < 50; i++){
//            vBox.getChildren().add(new RecipeNode(new Recipe("Борщ", "Русский", 4, 70, 300)));
//        }
    }

    @FXML
    private void addRecipeClick(ActionEvent actionEvent){
        System.out.println("Add recipe click!");
    }

    @FXML
    private void applyFilterClick(ActionEvent actionEvent){
        System.out.println("Apply filter click!");
    }

    @FXML
    private void clearFilterClick(ActionEvent actionEvent){
        category.getCheckModel().clearChecks();
        time.getCheckModel().clearChecks();
        hardness.getCheckModel().clearChecks();
        ingredient.getCheckModel().clearChecks();
    }
}
