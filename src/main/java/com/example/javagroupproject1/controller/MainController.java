package com.example.javagroupproject1.controller;

import com.example.javagroupproject1.Database;
import com.example.javagroupproject1.dao.DaoContext;
import com.example.javagroupproject1.data.Recipe;
import com.example.javagroupproject1.repository.RepositoryContext;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.layout.VBox;
import org.controlsfx.control.CheckComboBox;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private CheckComboBox<String> categories;

    @FXML
    private CheckComboBox<String> ingredients;

    @FXML
    private ComboBox<String> time;

    @FXML
    private ComboBox<String> favorite;

    @FXML
    private VBox veveBox;

    private static MainController instance;
    public static MainController getInstance(){
        return instance;
    }

    private RepositoryContext rc;
    private DaoContext dc;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;

        rc = Database.INSTANCE.repositoryContext;
        dc = Database.INSTANCE.daoContext;

        time.setButtonCell(new ListCell<String>(){
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty) ;
                setText(time.getPromptText());
            }
        });

        time.getItems().addAll("Любое", "По возрастанию", "По убыванию");
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

        update();
    }

    public void update(){
        updateRecipes();
        updateIngredients();
        updateCategories();
    }

    private void updateRecipes(Iterable<Recipe> recipes) {
        var children = veveBox.getChildren();
        children.clear();

        for (var a: recipes){
            children.add(new RecipeItem(a));
        }
    }

    private void updateIngredients(){
        ingredients.getItems().clear();
        rc.ingredientNameRepository.getAll().forEach(x -> ingredients.getItems().add(x.getName()));
    }

    private void updateCategories(){
        categories.getItems().clear();
        try {
            dc.categoryDao.queryForAll().forEach(x -> categories.getItems().add(x.getName()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateRecipes(){
        updateRecipes(rc.recipeRepository.getAll());
    }

    @FXML
    private void applyFilterClick(ActionEvent actionEvent){
        int a = favorite.getSelectionModel().getSelectedIndex();
        boolean b;

        if (a == 1) b = true;
        else b = false;

        updateRecipes(dc.recipeDao.sortAndFiltrate(
                categories.getCheckModel().getCheckedItems(),
                ingredients.getCheckModel().getCheckedItems(),
                time.getSelectionModel().getSelectedItem(),
                favorite.getSelectionModel().getSelectedItem()
        ));
    }

    @FXML
    private void clearFilterClick(ActionEvent actionEvent){
        categories.getItems().clear();
        ingredients.getItems().clear();

        time.getSelectionModel().clearAndSelect(0);
        favorite.getSelectionModel().clearAndSelect(0);

        update();
    }
}
