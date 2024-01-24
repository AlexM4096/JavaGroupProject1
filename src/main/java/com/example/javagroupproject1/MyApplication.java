package com.example.javagroupproject1;

import com.example.javagroupproject1.controller.SceneController;
import com.example.javagroupproject1.parsing.AdaptedWebData;
import com.example.javagroupproject1.parsing.WebData;
import com.example.javagroupproject1.parsing.WebDataAdapter;
import com.example.javagroupproject1.parsing.WebScraper;
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

        WebScraper webScraper = new WebScraper();
        WebData webData = webScraper.scrapeWebsite(
                "https://eda.ru/recepty/vypechka-deserty/kapustnij-pirog-17889",
                "C:\\Users\\trank\\OneDrive\\Документы\\Новая папка");
        WebDataAdapter webDataAdapter = new WebDataAdapter();
        AdaptedWebData adaptedWebData = webDataAdapter.adapt(webData);
        Database.INSTANCE.repositoryContext.recipes.add(adaptedWebData.recipe());

        SceneController sceneController = new SceneController(scene);
        sceneController.addScene("main", FXMLLoader.load(Objects.requireNonNull(getClass().getResource("views/main.fxml"))));
        sceneController.addScene("recipe", FXMLLoader.load(Objects.requireNonNull(getClass().getResource("views/recipe.fxml"))));
        sceneController.activateScene("main");

    }

    public static void main(String[] args) {
        launch();
    }
}
