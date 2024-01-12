package com.example.javagroupproject1.repository;

public interface IRepository<T extends IEntity> {
    Iterable<T> getAll();
    T getByID(long id);
    void add(T entity);
    void update(T entity);
    void delete(T entity);
}