package com.example.javagroupproject1.repository;

import com.example.javagroupproject1.dao.DaoContext;
import com.example.javagroupproject1.data.IngredientType;

import java.sql.SQLException;

public class IngredientTypeRepository extends RepositoryBase implements IIngredientTypeRepository {

    public IngredientTypeRepository(DaoContext dc) {
        super(dc);
    }

    @Override
    public Iterable<IngredientType> getAll() {
        try {
            return dc.ingredientTypeDao.queryForAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public IngredientType getByID(long id) {
        try {
            return dc.ingredientTypeDao.queryForId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(IngredientType entity) {
        try {
            dc.ingredientTypeDao.createIfNotExists(entity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(IngredientType entity) {
        try {
            dc.ingredientTypeDao.update(entity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(IngredientType entity) {
        try {
            dc.ingredientTypeDao.delete(entity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
