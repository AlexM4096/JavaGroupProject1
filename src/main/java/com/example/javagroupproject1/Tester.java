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
