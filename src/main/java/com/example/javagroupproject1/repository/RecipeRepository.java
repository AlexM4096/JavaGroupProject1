package com.example.javagroupproject1.repository;

import com.example.javagroupproject1.dao.DaoContext;
import com.example.javagroupproject1.data.Recipe;

import java.sql.SQLException;

public class RecipeRepository extends RepositoryBase implements IRecipeRepository {
    public RecipeRepository(DaoContext dc) {
        super(dc);
    }

    @Override
    public Iterable<Recipe> getAll() {
        try {
            return dc.recipeDao.queryForAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Recipe getByID(long id) {
        try {
            return dc.recipeDao.queryForId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Recipe entity) {
        try {
            dc.recipeDao.createIfNotExists(entity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Recipe entity) {
        try {
            dc.recipeDao.update(entity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Recipe entity) {
        try {
            dc.recipeDao.delete(entity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addOrUpdate(Recipe entity) {
        try {
            if (dc.recipeDao.idExists(entity.getID()))
                update(entity);
            else
                add(entity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
