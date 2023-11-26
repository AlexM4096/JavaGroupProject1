package com.example.javagroupproject1.data;


import java.util.ArrayList;
import java.util.List;
public class WebData {
    private String title;
    private List<String> ingredients;
    private List<String> preparationSteps;
    private List<String> imageUrls;

    public WebData() {
        ingredients = new ArrayList<>();
        preparationSteps = new ArrayList<>();
        imageUrls = new ArrayList<>();
    }

    // Getter для поля title
    public String getTitle() {
        return title;
    }
    // Setter для поля title
    public void setTitle(String title) {
        this.title = title;
    }
    // Getter для поля ingredients
    public List<String> getIngredients() {
        return ingredients;
    }
    //Setter для поля ingredients
    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
    // Getter для поля preparationSteps
    public List<String> getPreparationSteps() {
        return preparationSteps;
    }
    //Setter для поля preparationSteps
    public void setPreparationSteps(List<String> preparationSteps) {
        this.preparationSteps = preparationSteps;
    }
    // Getter для поля imageUrls
    public List<String> getImageUrls() {
        return imageUrls;
    }
    //Setter для поля imageUrls
    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }
}