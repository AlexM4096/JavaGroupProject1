package com.example.javagroupproject1.controller;

import com.example.javagroupproject1.Database;
import com.example.javagroupproject1.repository.RepositoryContext;
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
    private CheckComboBox<String> ingredient;

    @FXML
    private VBox vBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RepositoryContext rc = Database.INSTANCE.repositoryContext;
        var children = vBox.getChildren();

        for (var a: rc.recipes.getAll()){
            children.add(new RecipeItem(a));
        }
    }

    @FXML
    private void applyFilterClick(ActionEvent actionEvent){
        System.out.println("Apply filter click!");
    }

    @FXML
    private void clearFilterClick(ActionEvent actionEvent){
        category.getCheckModel().clearChecks();
        time.getCheckModel().clearChecks();
        ingredient.getCheckModel().clearChecks();
    }
}
