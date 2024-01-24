package com.example.javagroupproject1.parsing;

import com.example.javagroupproject1.Database;
import com.example.javagroupproject1.controller.MainController;
import com.example.javagroupproject1.controller.RecipeController;
import com.example.javagroupproject1.controller.SceneController;
import com.example.javagroupproject1.dao.DaoContext;
import com.example.javagroupproject1.data.IngredientName;
import com.example.javagroupproject1.data.Recipe;
import com.example.javagroupproject1.repository.RepositoryContext;
import com.example.javagroupproject1.tools.Prefs;

import java.sql.SQLException;
import java.util.List;

public class WebReader {
    public static final String OUTPUT_PATH = "temp";
    public static final String WEBSITE_URL = "https://eda.ru/recepty";

    private static final WebScraper webScraper = new WebScraper();
    private static final WebDataAdapter webDataAdapter = new WebDataAdapter();
    private static final RepositoryContext rc = Database.INSTANCE.repositoryContext;
    private static final DaoContext dc = Database.INSTANCE.daoContext;


    public static void readLink(String url){
        if (!url.startsWith(WEBSITE_URL)) return;

        WebData webData = webScraper.scrapeWebsite(url, OUTPUT_PATH);
        AdaptedWebData adaptedWebData = webDataAdapter.adapt(webData);

        Recipe recipe = adaptedWebData.recipe();
        rc.recipeRepository.add(recipe);

        List<IngredientName> ingredientNames = adaptedWebData.ingredientNames();
        for (var a: ingredientNames){
            try {
                var b = dc.ingredientNameDao.queryForEq("name", a.getName());

                if (b.isEmpty()){
                    rc.ingredientNameRepository.add(a);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        Prefs.getInstance().createOrUpdate("recipe", recipe);
        MainController.getInstance().update();
        RecipeController.getInstance().update();
        SceneController.instance.activateScene("recipe");
    }
}
