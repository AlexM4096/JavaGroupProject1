package com.example.javagroupproject1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CatalogItem extends VBox {
    private static FXMLLoader fxmlLoader;

    @FXML
    private ImageView image;
    @FXML
    private Label title;

    public static void Init(){
        FXMLLoader fxmlLoader = new FXMLLoader(MyApplication.class.getResource("Catalog-item.fxml"));
    }

    public CatalogItem(String title, Image image) {
        try {
            fxmlLoader.load();

            this.title.setText(title);
            this.image.setImage(image);

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
