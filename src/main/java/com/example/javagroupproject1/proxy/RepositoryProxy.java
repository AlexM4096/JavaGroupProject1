package com.example.javagroupproject1.proxy;

import com.example.javagroupproject1.repository.IRepository;

import java.util.HashMap;
import java.util.Map;

public class RepositoryProxy<T> implements IRepository<T> {
    public final IRepository<T> repository;
    public final Map<Integer, T> entityCache;

    public RepositoryProxy(IRepository<T> repository){
        this.repository = repository;
        this.entityCache = new HashMap<>();
    }

    @Override
    public Iterable<T> GetAll() {
        return null;
    }

    @Override
    public T GetByID(long id) {
        return null;
    }

    @Override
    public void Add(T entity) {

    }

    @Override
    public void Update(T entity) {

    }

    @Override
    public void Delete(T entity) {

    }
}
