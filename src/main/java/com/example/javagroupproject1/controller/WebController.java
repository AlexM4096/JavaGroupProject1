package com.example.javagroupproject1.controller;

import com.example.javagroupproject1.Database;
import com.example.javagroupproject1.parsing.WebReader;
import com.example.javagroupproject1.repository.RepositoryContext;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class WebController implements Initializable {

    @FXML
    private void linkClick(ActionEvent event){
        try {
            Desktop.getDesktop().browse(new URI(WebReader.WEBSITE_URL));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private TextField link;

    @FXML
    private void addClick(ActionEvent event){
        WebReader.readLink(link.getText());
    }

    private static WebController instance;

    public static WebController getInstance() {
        return instance;
    }

    private RepositoryContext rc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instance = this;

        rc = Database.INSTANCE.repositoryContext;
    }
}
