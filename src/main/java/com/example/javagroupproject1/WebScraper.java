package com.example.javagroupproject1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebScraper {
    private String Title;
    private List<String> ingredients;
    private List<String> preparationSteps;

    public WebScraper() {
        ingredients = new ArrayList<>();
        preparationSteps = new ArrayList<>();
    }

    public void scrapeWebsite(String url) {
        try {
            // Загрузка HTML-страницы
            Document document = Jsoup.connect(url).get();

            // Извлечение названия блюда
            Element titleElement = document.select("h1.emotion-gl52ge").get(0);
            String title = (titleElement != null) ? titleElement.text() : "Название не найдено";
            Title = title;

            // Извлечение ингредиентов
            Elements ingredientElements = document.select("div.emotion-7yevpr");
            for (Element ingredientElement : ingredientElements) {
                ingredients.add(ingredientElement.text());
            }

            // Извлечение шагов приготовления
            Elements preparationStepElements = document.select("span.emotion-wdt5in");
            System.out.println("Шаги приготовления:");
            for (Element preparationStepElement : preparationStepElements) {
                preparationSteps.add(preparationStepElement.text());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTitle() {
        return Title;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<String> getPreparationSteps() {
        return preparationSteps;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Введите url");
            return;
        }

        String url = args[0];
        WebScraper scraper = new WebScraper();
        scraper.scrapeWebsite(url);


        String title = scraper.getTitle();
        List<String> ingredients = scraper.getIngredients();
        List<String> preparationSteps = scraper.getPreparationSteps();

        if (title != null) {
            System.out.println("Название блюда: " + title);
        } else {
            System.out.println("Название блюда не найдено");
        }

        if (ingredients != null) {
            System.out.println("Ингредиенты:");
            for (String ingredient : ingredients) {
                System.out.println(ingredient);
            }
        } else {
            System.out.println("Ингредиенты не найдены");
        }

        if (preparationSteps != null) {
            System.out.println("Шаги приготовления:");
            for (String step : preparationSteps) {
                System.out.println(step);
            }
        } else {
            System.out.println("Шаги приготовления не найдены");
        }
    }
}