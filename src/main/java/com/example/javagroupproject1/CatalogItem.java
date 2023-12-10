package com.example.javagroupproject1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class CatalogItem extends VBox {
    public CatalogItem(String _title, Image _image) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Catalog-item.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
            title.setText(_title);
            imageview.setImage(_image);

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    @FXML
    private ImageView imageview;
    @FXML
    private Label title;
}
