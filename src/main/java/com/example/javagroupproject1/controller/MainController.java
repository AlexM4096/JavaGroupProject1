package com.example.javagroupproject1.controller;

import com.example.javagroupproject1.Database;
import com.example.javagroupproject1.repository.RepositoryContext;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.layout.VBox;
import org.controlsfx.control.CheckComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private CheckComboBox<String> category;

    @FXML
    private CheckComboBox<String> ingredient;

    @FXML
    private ComboBox<String> time;

    @FXML
    private ComboBox<String> favorite;

    @FXML
    private VBox vBox;

    private static MainController instance;
    public static MainController getInstance(){
        return instance;
    }

    private RepositoryContext rc;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;

        rc = Database.INSTANCE.repositoryContext;

        time.setButtonCell(new ListCell<String>(){
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty) ;
                setText(time.getPromptText());
            }
        });

        time.getItems().addAll("Любые", "По возрастанию", "По убыванию");
        time.getSelectionModel().select(0);

        favorite.setButtonCell(new ListCell<String>(){
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty) ;
                setText(favorite.getPromptText());
            }
        });

        favorite.getItems().addAll("Любые", "Только избранные", "Только не избранные");
        favorite.getSelectionModel().select(0);

        var children = vBox.getChildren();

        for (var a: rc.recipes.getAll()){
            children.add(new RecipeItem(a));
        }
    }

    public void update(){
        var children = vBox.getChildren();
        children.clear();

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
        ingredient.getCheckModel().clearChecks();
        time.getSelectionModel().clearAndSelect(0);
        favorite.getSelectionModel().clearAndSelect(0);
    }
}
