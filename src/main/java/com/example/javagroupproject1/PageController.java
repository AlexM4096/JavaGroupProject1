package com.example.javagroupproject1;

import javafx.stage.Stage;

import java.io.IOException;

public class PageController {
    private Stage stage;
    public void change(Page page){
        try {
            System.out.println(this.stage);
            if (stage.getScene()!=null){
                double width=stage.getScene().getWidth();
                double height= stage.getScene().getHeight();
                stage.setScene(page.getSceneOfPage());
                stage.setWidth(width);
                stage.setHeight(height);
            }
           else {
                stage.setScene(page.getSceneOfPage());
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    private static PageController instance;
    private PageController() { }
    public void setStage(Stage _stage) {
        if (instance != null) {
            instance.stage = _stage;
            instance.stage.show();
        }
    }
    public static PageController getInstance() {
        if (instance == null) {
            instance = new PageController();
        }
        return instance;
    }
}
