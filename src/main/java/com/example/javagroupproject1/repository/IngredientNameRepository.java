package com.example.javagroupproject1.repository;

import com.example.javagroupproject1.dao.DaoContext;
import com.example.javagroupproject1.data.IngredientName;

import java.sql.SQLException;

public class IngredientNameRepository extends RepositoryBase implements IIngredientNameRepository{
    public IngredientNameRepository(DaoContext dc) {
        super(dc);
    }

    @Override
    public Iterable<IngredientName> getAll() {
        try {
            return dc.ingredientNameDao.queryForAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public IngredientName getByID(long id) {
        try {
            return dc.ingredientNameDao.queryForId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(IngredientName entity) {
        try {
            dc.ingredientNameDao.createIfNotExists(entity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(IngredientName entity) {
        try {
            dc.ingredientNameDao.update(entity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(IngredientName entity) {
        try {
            dc.ingredientNameDao.delete(entity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addOrUpdate(IngredientName entity) {
        try {
            if (dc.ingredientNameDao.idExists(entity.getID()))
                update(entity);
            else
                add(entity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
