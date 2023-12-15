package com.example.javagroupproject1.parsing;


import java.util.ArrayList;
import java.util.List;
public class WebData {
    private String category;
    private String title;
    private String time;
    private List<String> ingredients;
    private List<String> preparationSteps;
    private Double portions;
    private Double calories;
    private Double proteins;
    private Double fats;
    private Double carbohydrates;
    private List<String> imageUrls;


    public WebData() {
        ingredients = new ArrayList<>();
        preparationSteps = new ArrayList<>();
        imageUrls = new ArrayList<>();
    }

    // Getter для поля category
    public String getCategory() {
        return category;
    }
    // Setter для поля category
    public void setCategory(String category) {
        this.category = category;
    }

    // Getter для поля title
    public String getTitle() {
        return title;
    }
    // Setter для поля title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter для поля time
    public String getTime() {
        return time;
    }
    // Setter для поля title
    public void setTime(String time) {
        this.time = time;
    }
    // Getter для поля ingredients
    public List<String> getIngredients() {
        return ingredients;
    }
    //Setter для поля ingredients
    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    // Getter для поля portions
    public Double getPortions() {
        return portions;
    }
    // Setter для поля portions
    public void setPortions(Double portions) {
        this.portions = portions;
    }

    // Getter для поля calories
    public Double getCalories() {
        return calories;
    }
    // Setter для поля calories
    public void setCalories(Double calories) {
        this.calories = calories;
    }

    // Getter для поля proteins
    public Double getProteins() {
        return proteins;
    }
    // Setter для поля calories
    public void setProteins(Double proteins) {
        this.proteins = proteins;
    }

    // Getter для поля proteins
    public Double getFats() {
        return fats;
    }
    // Setter для поля calories
    public void setFats(Double fats) {
        this.fats = fats;
    }

    // Getter для поля carbohydrates
    public Double getCarbohydrates() {
        return carbohydrates;
    }
    // Setter для поля carbohydrates
    public void setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
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