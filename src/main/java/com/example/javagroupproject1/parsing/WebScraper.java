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

            // Извлечение категории блюда
            Element categoryElement = document.select("span.emotion-1h6i17m").get(1);
            String category = (categoryElement != null) ? categoryElement.text() : "Название не найдено";
            Data.setCategory(category);

            // Извлечение названия блюда
            Element titleElement = document.selectFirst("h1.emotion-gl52ge");
            String title = (titleElement != null) ? titleElement.text() : "Название не найдено";
            data.setTitle(title);

            // Извлечение времени приготовления блюда
            Element timeElement = document.selectFirst("div.emotion-my9yfq");
            String time = (timeElement != null) ? timeElement.text() : "Название не найдено";
            Data.setTime(time);

            // Извлечение кол-ва порций блюда
            Element portionsElement = document.selectFirst("div.emotion-1047m5l");
            String portions = (portionsElement != null) ? portionsElement.text() : "Название не найдено";
            Data.setPortions(Double.parseDouble(portions));

            // Извлечение каллорий блюда
            Element caloriesElement = document.selectFirst("[itemprop=calories]");
            String calories = (caloriesElement != null) ? caloriesElement.text() : "Название не найдено";
            Data.setCalories(Double.parseDouble(calories)*Data.getPortions());

            // Извлечение белков блюда
            Element proteinsElement = document.selectFirst("[itemprop=proteinContent]");
            String proteins = (proteinsElement != null) ? proteinsElement.text() : "Название не найдено";
            Data.setProteins(Double.parseDouble(proteins)*Data.getPortions());

            // Извлечение жиров блюда
            Element fatsElement = document.selectFirst("[itemprop=fatContent]");
            String fats = (fatsElement != null) ? fatsElement.text() : "Название не найдено";
            Data.setFats(Double.parseDouble(fats)*Data.getPortions());

            // Извлечение углеводов блюда
            Element carbohydratesElement = document.selectFirst("[itemprop=carbohydrateContent]");
            String carbohydrates = (carbohydratesElement != null) ? carbohydratesElement.text() : "Название не найдено";
            Data.setCarbohydrates(Double.parseDouble(carbohydrates)*Data.getPortions());

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