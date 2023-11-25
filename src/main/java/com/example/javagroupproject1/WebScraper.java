package com.example.javagroupproject1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class WebScraper {
    private String Title;
    private List<String> ingredients;
    private List<String> preparationSteps;
    private List<String> imageUrls;


    public WebScraper() {
        ingredients = new ArrayList<>();
        preparationSteps = new ArrayList<>();
        imageUrls = new ArrayList<>();
    }

    public void scrapeWebsite(String url, String outPut) {
        try {
            // Загрузка HTML-страницы
            Document document = Jsoup.connect(url).get();

            // Извлечение изображений шагов приготовления
            Elements imgTitleElements = document.select("img.emotion-gxbcya");
            for (Element imgElement : imgTitleElements) {
                String imageUrl = imgElement.attr("src");
                imageUrls.add(imageUrl);
            }

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
            int count = 1;
            for (Element preparationStepElement : preparationStepElements) {
                preparationSteps.add(count+". "+preparationStepElement.text());
                count++;
            }

            // Извлечение изображений шагов приготовления
            Elements imgElements = document.select("img.emotion-ducv57");
            for (Element imgElement : imgElements) {
                String imageUrl = imgElement.attr("src");
                imageUrls.add(imageUrl);
            }
            // Скачивание и сохранение изображения шагов приготовления
            downloadImages(imageUrls,outPut,preparationSteps, Title);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void downloadImages(List<String> imageUrls, String outputFolder, List<String> preparationSteps, String Title) {
        for (int i = 0; i < imageUrls.size(); i++) {
            String imageUrl = imageUrls.get(i);
            try {
                String fileName;
                String title = Title.replace(" ", "-");
                // Создание URL изображения
                URL url = new URL(imageUrl);

                if(imageUrls.size() > preparationSteps.size())
                {
                    if (i == 0){
                        fileName = "image" + "Title" + "_" + title+imageUrl.substring(imageUrl.lastIndexOf("."));
                    }
                    else {
                        fileName = "image" + (i-1) + "_" + title+imageUrl.substring(imageUrl.lastIndexOf("."));
                    }
                }
                else{
                    fileName = "image" + i + "_" + title+imageUrl.substring(imageUrl.lastIndexOf("."));
                }

                // Скачивание и сохранение изображения
                try (InputStream in = url.openStream()) {
                    Path outputPath = Path.of(outputFolder, fileName);
                    Files.copy(in, outputPath, StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
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
        if (args.length != 2) {
            System.out.println("Введите url и путь для папки сохранения картинок");
            return;
        }
        String url = args[0];
        String outPut = args[1];
        WebScraper scraper = new WebScraper();
        scraper.scrapeWebsite(url, outPut);


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