package com.example.javagroupproject1;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addrecipe.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
        /*stage.setTitle("Hello!");
        PageController.getInstance().setStage(stage);
        PageController.getInstance().change(new CatalogPage());*/
    }

    public static void main(String[] args) {
        launch();
    }
}
