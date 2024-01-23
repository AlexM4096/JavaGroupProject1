package com.example.javagroupproject1.controller;

import com.example.javagroupproject1.data.Recipe;
import com.example.javagroupproject1.tools.SerializableImage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import org.controlsfx.control.CheckComboBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

        for (int i =0; i < 50; i++){
            Recipe recipe = new Recipe();
            try {
                FileInputStream fileInputStream =  new FileInputStream("D:\\Apps\\IntelliJ IDEA\\IdeaProjects\\JavaGroupProject1\\src\\main\\resources\\com\\example\\javagroupproject1\\images\\bul.png");
                recipe.setImage(new SerializableImage(new Image(fileInputStream)));
                vBox.getChildren().add(new RecipeNode(recipe));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
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
