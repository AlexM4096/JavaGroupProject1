package com.example.javagroupproject1.tools;

import javafx.event.Event;

import java.util.HashMap;

public class Prefs {

    private static Prefs instance;

    private final HashMap<String, Object> map = new HashMap<>();

    public static Prefs getInstance(){
        if (instance != null) return instance;

        instance = new Prefs();
        return instance;
    }

    public void create(String string, Object object){
        map.put(string, object);
    }

    public Object read(String string){
        return map.get(string);
    }

    public void update(String string, Object object){
        map.replace(string, object);
    }

    public void delete(String string){
        map.remove(string);
    }

    public void createOrUpdate(String string, Object object){
        if (map.containsKey(string))
            update(string, object);
        else
            create(string, object);
    }
}
