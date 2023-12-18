package com.example.javagroupproject1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CatalogPage extends VBox implements IPage {
    private Scene scene;
    @Override
    public Scene getSceneOfPage(){
        return this.scene;

    };
    private Scene load(){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Spisok.fxml"));
        fxmlLoader.setController(this);
        try {
            return new Scene(fxmlLoader.load());
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public CatalogPage(){
        this.scene=load();
        for (int i=0;i<4; i++){
            /*CatalogItem item= new CatalogItem();
            FlowPaneCatalogItems.getChildren().add(item);*/
        }
        CatalogItem item4= new CatalogItem("Завтраки",new Image("/zav.png"));
        FlowPaneCatalogItems.add(item4,0,0);
        CatalogItem item1= new CatalogItem("Бульоны",new Image("/bul.png"));
        FlowPaneCatalogItems.add(item1,1,0);
        CatalogItem item2= new CatalogItem("Закуски",new Image("/закуски 1.png"));
        FlowPaneCatalogItems.add(item2,2,0);
        CatalogItem item3= new CatalogItem("Сэндвичи",new Image("/сендвичи 1.png"));
        FlowPaneCatalogItems.add(item3,3,0);
        //FlowPaneCatalogItems.getChildren().add(item3);
        CatalogItem item5= new CatalogItem("Основные",new Image("/основные.png"));
        FlowPaneCatalogItems.add(item5,0,1);
        CatalogItem item6= new CatalogItem("Салаты",new Image("/салаты 1.png"));
        FlowPaneCatalogItems.add(item6,1,1);
        CatalogItem item7= new CatalogItem("Супы",new Image("/супы 1.png"));
        FlowPaneCatalogItems.add(item7,2,1);
        CatalogItem item8= new CatalogItem("Десерты",new Image("/десерты 1.png"));
        FlowPaneCatalogItems.add(item8,3,1);
        //FlowPaneCatalogItems.getChildren().add(item3);
        System.out.println(FlowPaneCatalogItems.getChildren().size());
        ObservableList<String> sortlist= FXCollections.observableArrayList("Сначала легкие","сначала сложные","Сначала долгие", "Сначала быстрые");
        choiceboxsort.setItems(sortlist);
        choiceboxsort.getSelectionModel().select(0);
    }

    @FXML
    private GridPane FlowPaneCatalogItems;
    @FXML
    protected void onOpenRecipesPageButtonClick(){
        PageController.getInstance().change(new CatalogPage());
    }
    @FXML
    private ChoiceBox choiceboxsort;
}
