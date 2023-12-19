package com.example.javagroupproject1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.CheckComboBox;

import java.io.IOException;

public class MyApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(MyApplication.class.getResource("views/filt.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 400, 300);


        ObservableList<String> observableList = FXCollections.observableArrayList();
        for (int i = 0; i < 40; i++){
            observableList.add(String.valueOf(i));
        }
        CheckComboBox<String> checkListView = new CheckComboBox<>(observableList);
        checkListView.setTitle("Ингридиенты");
        VBox vBox = new VBox(checkListView);

        Scene scene = new Scene(vBox);

        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
