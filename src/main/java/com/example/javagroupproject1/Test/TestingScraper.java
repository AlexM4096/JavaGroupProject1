package com.example.javagroupproject1.Test;

import com.example.javagroupproject1.WebScraper;
import com.example.javagroupproject1.data.WebData;

public class TestingScraper {
    public static void main(String[] args) {
        WebScraper webScraper = new WebScraper();
        String url = args[0]; // URL
        String outputFolder = args[1]; // папка для сохранения изображений

        // Вызываем метод scrapeWebsite и получаем данные
        WebData webData = webScraper.scrapeWebsite(url, outputFolder);

        // Печатаем полученные данные
        printWebData(webData);
    }

    private static void printWebData(WebData webData) {
        if (webData != null) {
            System.out.println("Название блюда: " + webData.getTitle());
            System.out.println("Ингредиенты:");
            for (String ingredient : webData.getIngredients()) {
                System.out.println(ingredient);
            }
            System.out.println("Шаги приготовления:");
            for (String step : webData.getPreparationSteps()) {
                System.out.println(step);
            }
        } else {
            System.out.println("Данные не были получены.");
        }
    }
}
