package com.example.javagroupproject1;

import com.example.javagroupproject1.controller.SceneController;
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

        SceneController sceneController = new SceneController(scene);
        sceneController.addScene("main", FXMLLoader.load(Objects.requireNonNull(getClass().getResource("views/main.fxml"))));
        sceneController.addScene("recipe", FXMLLoader.load(Objects.requireNonNull(getClass().getResource("views/recipe.fxml"))));
        sceneController.addScene("web", FXMLLoader.load(Objects.requireNonNull(getClass().getResource("views/web.fxml"))));
        sceneController.activateScene("main");
    }

    public static void main(String[] args) {
        launch();
    }
}
