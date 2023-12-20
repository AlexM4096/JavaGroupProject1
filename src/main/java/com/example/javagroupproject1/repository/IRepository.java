package com.example.javagroupproject1.repository;

public interface IRepository<T> {
    Iterable<T> GetAll();
    T GetByID(long id);
    void Add(T entity);
    void Update(T entity);
    void Delete(T entity);
}