package com.example.javagroupproject1.parsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class WebScraper {
    public WebData scrapeWebsite(String url, String outPut) {
        WebData data = new WebData();

        try {
            // Загрузка HTML-страницы
            Document document = Jsoup.connect(url).get();
            List<String> imageUrls = new ArrayList<>();

            // Извлечение изображения блюда
            Elements imgTitleElements = document.select("img.emotion-gxbcya");
            for (Element imgElement : imgTitleElements) {
                String imageUrl = imgElement.attr("src");
                imageUrls.add(imageUrl);
            }

            // Извлечение названия блюда
            Element titleElement = document.selectFirst("h1.emotion-gl52ge");
            String title = (titleElement != null) ? titleElement.text() : "Название не найдено";
            data.setTitle(title);

            // Извлечение ингредиентов
            Elements ingredientElements = document.select("div.emotion-7yevpr");
            List<String> ingredients = new ArrayList<>();
            for (Element ingredientElement : ingredientElements) {
                ingredients.add(ingredientElement.text());
            }
            data.setIngredients(ingredients);

            // Извлечение шагов приготовления
            Elements preparationStepElements = document.select("span.emotion-wdt5in");
            int count = 1;
            List<String> preparationSteps = new ArrayList<>();
            for (Element preparationStepElement : preparationStepElements) {
                preparationSteps.add(count+". "+preparationStepElement.text());
                count++;
            }
            data.setPreparationSteps(preparationSteps);

            // Извлечение изображений шагов приготовления
            Elements imgElements = document.select("img.emotion-ducv57");
            for (Element imgElement : imgElements) {
                String imageUrl = imgElement.attr("src");
                imageUrls.add(imageUrl);
            }
            data.setImageUrls(imageUrls);
            // Скачивание и сохранение изображения шагов приготовления
            downloadImages(data,outPut);
            return data;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void downloadImages(WebData Data, String outputFolder) {
        String title = Data.getTitle().replace(" ", "-");
        String outputFolder1 = outputFolder + "\\" + title;

        for (int i = 0; i < Data.getImageUrls().size(); i++) {
            String imageUrl = Data.getImageUrls().get(i);
            try {
                String fileName;
                // Создание URL изображения
                URL url = new URL(imageUrl);

                if(Data.getImageUrls().size() > Data.getPreparationSteps().size())
                {
                    if (i == 0){
                        fileName = "image" + "Title" + "_" + imageUrl.substring(imageUrl.lastIndexOf("."));
                    }
                    else {
                        fileName = "image" + (i-1) + "_" + imageUrl.substring(imageUrl.lastIndexOf("."));
                    }
                }
                else{
                    fileName = "image" + i + "_" + imageUrl.substring(imageUrl.lastIndexOf("."));
                }

                // Скачивание и сохранение изображения
                try (InputStream in = url.openStream()) {
                    Path outputPath = Path.of(outputFolder1, fileName);
                    Files.createDirectories(outputPath.getParent()); // Создаем директорию, если её нет
                    Files.copy(in, outputPath, StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args) {

    }

}