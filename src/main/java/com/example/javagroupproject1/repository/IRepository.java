package com.example.javagroupproject1.repository;

public interface IRepository<T> {
    // Create
    void Add(T entity);

    // Read
    T Find(int id);

    // Update
    void Update(T entity);

    // Delete
    void Remove(T entity);
}