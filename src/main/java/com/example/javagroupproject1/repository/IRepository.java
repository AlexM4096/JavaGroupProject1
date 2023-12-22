package com.example.javagroupproject1.repository;

import com.example.javagroupproject1.data.IEntity;

public interface IRepository<T extends IEntity> {
    Iterable<T> getAll();
    T getByID(long id);
    void add(T entity);
    void update(T entity);
    void delete(T entity);
}