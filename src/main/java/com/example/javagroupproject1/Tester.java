package com.example.javagroupproject1;

import com.example.javagroupproject1.parsing.WebData;
import com.example.javagroupproject1.parsing.WebScraper;

public class Tester {
    public static void main(String[] args) {
        WebScraper webScraper = new WebScraper();
        String url = "https://eda.ru/recepty/zakuski/svinye-ushi-po-kitayski-175151"; // URL
        String outputFolder = "C:\\Users\\trank\\IdeaProjects\\parser2\\img"; // папка для сохранения изображений

        // Вызываем метод scrapeWebsite и получаем данные
        WebData webData = webScraper.scrapeWebsite(url, outputFolder);

        // Печатаем полученные данные
        printWebData(webData);
    }

    private static void printWebData(WebData webData) {
        if (webData != null) {
            System.out.println("Категория блюда: " + webData.getCategory());
            System.out.println("Название блюда: " + webData.getTitle());
            System.out.println("Время приготовление: " + webData.getTime());
            System.out.println("Ингредиенты:");
            for (String ingredient : webData.getIngredients()) {
                System.out.println(ingredient);
            }
            System.out.println("Каллорийность в ккал: " + webData.getCalories());
            System.out.println("Белки в граммах: " + webData.getProteins());
            System.out.println("Жиры в граммах: " + webData.getFats());
            System.out.println("Углеводы в граммах: " + webData.getCarbohydrates());
            System.out.println("Шаги приготовления:");
            for (String step : webData.getPreparationSteps()) {
                System.out.println(step);
            }
        } else {
            System.out.println("Данные не были получены.");
        }
    }
}
