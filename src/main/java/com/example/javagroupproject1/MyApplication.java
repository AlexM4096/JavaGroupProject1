package com.example.javagroupproject1;

import com.example.javagroupproject1.controller.SceneController;
import com.example.javagroupproject1.data.Recipe;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MyApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new Pane(), 400, 300);
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();

        Recipe recipe = new Recipe();
        recipe.setName("Иди нахй сука");
        Database.INSTANCE.repositoryContext.recipes.add(recipe);

        for (var a : Database.INSTANCE.repositoryContext.recipes.getAll()){
            System.out.println(a.getName());
        }

        SceneController sceneController = new SceneController(scene);
        sceneController.addScene("main", FXMLLoader.load(Objects.requireNonNull(getClass().getResource("views/main.fxml"))));
        sceneController.addScene("recipe", FXMLLoader.load(Objects.requireNonNull(getClass().getResource("views/recipe.fxml"))));
        sceneController.activateScene("main");

    }

    public static void main(String[] args) {
        launch();
    }
}
