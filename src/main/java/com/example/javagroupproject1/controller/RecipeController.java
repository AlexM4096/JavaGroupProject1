package com.example.javagroupproject1.controller;

import com.example.javagroupproject1.Database;
import com.example.javagroupproject1.dao.DaoContext;
import com.example.javagroupproject1.data.Category;
import com.example.javagroupproject1.data.Recipe;
import com.example.javagroupproject1.repository.RepositoryContext;
import com.example.javagroupproject1.tools.Prefs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RecipeController implements Initializable {

    @FXML
    private TextField name;

    @FXML
    private TextField portions;

    @FXML
    private TextField time;

    @FXML
    private ImageView image;

    @FXML
    private ComboBox<String> categories;

    @FXML
    private void saveClick(){

        recipe.setName(name.getText());
        if (image.getImage() != null) recipe.setImage(image.getImage());
        recipe.setPortionsAmount(Integer.parseInt(portions.getText()));
        recipe.setCookingTimeMinutes(Integer.parseInt(time.getText()));

        try {
            var name = categories.getSelectionModel().getSelectedItem();
            if (name != null){
                var a = dc.categoryDao.queryForEq("name", name);
                if (a.isEmpty()){
                    recipe.setCategory(new Category(name));
                }
                else {
                    recipe.setCategory(a.getFirst());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        rc.recipeRepository.addOrUpdate(recipe);

        MainController.getInstance().update();
        SceneController.instance.activateScene("main");
    }

    @FXML
    private void closeClick(){
        MainController.getInstance().update();
        SceneController.instance.activateScene("main");
    }

    @FXML
    private void deleteClick(){
        rc.recipeRepository.delete(recipe);

        MainController.getInstance().update();
        SceneController.instance.activateScene("main");
    }

    private static RecipeController instance;
    public static RecipeController getInstance(){
        return instance;
    }

    private RepositoryContext rc;
    private DaoContext dc;

    private Recipe recipe;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instance = this;

        rc = Database.INSTANCE.repositoryContext;
        dc = Database.INSTANCE.daoContext;
    }

    public void update(){
        recipe = (Recipe) Prefs.getInstance().read("recipe");

        categories.getItems().clear();
        categories.getSelectionModel().clearSelection();
        try {
            dc.categoryDao.queryForAll().forEach(x -> categories.getItems().add(x.getName()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        categories.getSelectionModel().select(recipe.getCategoryName());

        name.setText(recipe.getName());
        if (recipe.getImage() != null) image.setImage(recipe.getImage());
        portions.setText(String.valueOf(recipe.getPortionsAmount()));
        time.setText(String.valueOf(recipe.getCookingTimeMinutes()));
    }

    @FXML
    private void imageClick(ActionEvent event){

    }
}
