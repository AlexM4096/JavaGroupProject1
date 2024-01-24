package com.example.javagroupproject1.parsing;


import java.util.ArrayList;
import java.util.List;

public class WebData {
    private String category;
    private String title;
    private String time;
    private Integer portions;
    private Integer calories;
    private Integer proteins;
    private Integer fats;
    private Integer carbohydrates;
    public final List<String> ingredients;
    public final List<String> preparationSteps;
    public final List<String> imageUrls;


    public WebData() {
        ingredients = new ArrayList<>();
        preparationSteps = new ArrayList<>();
        imageUrls = new ArrayList<>();
    }

    //region Properties

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getPortions() {
        return portions;
    }

    public void setPortions(Integer portions) {
        this.portions = portions;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getProteins() {
        return proteins;
    }

    public void setProteins(Integer proteins) {
        this.proteins = proteins;
    }

    public Integer getFats() {
        return fats;
    }

    public void setFats(Integer fats) {
        this.fats = fats;
    }

    public Integer getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Integer carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    //endregion
}