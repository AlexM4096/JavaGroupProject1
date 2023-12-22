package com.example.javagroupproject1.proxy;

import com.example.javagroupproject1.data.IEntity;
import com.example.javagroupproject1.repository.IRepository;

import java.util.HashMap;
import java.util.Map;

public abstract class RepositoryProxy<T extends IEntity> implements IRepository<T> {
    public final IRepository<T> repository;
    public final Map<Long, T> entityCache;

    public RepositoryProxy(IRepository<T> repository) {
        this.repository = repository;
        this.entityCache = new HashMap<>();

        for (T t: repository.getAll()) {
            entityCache.put(t.getID(), t);
        }
    }

    @Override
    public Iterable<T> getAll() {
        return entityCache.values();
    }

    @Override
    public T getByID(long id) {
        if (entityCache.containsKey(id)){
            return entityCache.get(id);
        }

        T entity = repository.getByID(id);
        entityCache.put(id, entity);

        return  entity;
    }

    @Override
    public void add(T entity) {
        if (containsId(entity)){
            return;
        }

        repository.add(entity);
        entityCache.put(entity.getID(), entity);
    }

    @Override
    public void update(T entity) {
        if (!containsId(entity)){
            return;
        }

        repository.update(entity);
        entityCache.replace(entity.getID(), entity);
    }

    @Override
    public void delete(T entity) {
        if (!containsId(entity)){
            return;
        }

        repository.delete(entity);
        entityCache.remove(entity.getID());
    }

    private boolean containsId(T entity){
        return entityCache.containsKey(entity.getID());
    }
}
