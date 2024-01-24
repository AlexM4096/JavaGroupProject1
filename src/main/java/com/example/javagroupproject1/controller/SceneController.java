package com.example.javagroupproject1.controller;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class SceneController {

    public static SceneController instance;

    private final HashMap<String, Pane> screenMap = new HashMap<>();
    private final Scene main;
    private String currentScene = "";

    public SceneController(Scene main) {
        this.main = main;

        instance = this;
    }

    public void addScene(String name, Pane pane){
        screenMap.put(name, pane);
    }

    public void removeScene(String name){
        screenMap.remove(name);
    }

    public void activateScene(String name){
        if (currentScene.equals(name)) return;

        currentScene = name;
        main.setRoot(screenMap.get(name));
    }
}
