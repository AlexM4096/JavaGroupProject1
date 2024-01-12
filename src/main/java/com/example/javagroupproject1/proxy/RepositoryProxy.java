package com.example.javagroupproject1.proxy;

import com.example.javagroupproject1.repository.IEntity;
import com.example.javagroupproject1.repository.IRepository;

import java.util.HashMap;
import java.util.Map;

public abstract class RepositoryProxy<TEntity extends IEntity, TRepository extends IRepository<TEntity>>
        implements IRepository<TEntity> {

    public final TRepository repository;
    public final Map<Long, TEntity> map;

    public RepositoryProxy(TRepository repository) {
        this.repository = repository;
        this.map = new HashMap<>();

        cache();
    }

    protected void cache(){
        Iterable<TEntity> entities = repository.getAll();
        for (TEntity entity: entities) {
            map.put(entity.getID(), entity);
        }
    }

    @Override
    public Iterable<TEntity> getAll() {
        return map.values();
    }

    @Override
    public TEntity getByID(long id) {
        if (map.containsKey(id)){
            return map.get(id);
        }

        TEntity entity = repository.getByID(id);
        map.put(id, entity);

        return  entity;
    }

    @Override
    public void add(TEntity entity) {
        if (contains(entity)){
            return;
        }

        repository.add(entity);
        map.put(entity.getID(), entity);
    }

    @Override
    public void update(TEntity entity) {
        if (!contains(entity)){
            return;
        }

        repository.update(entity);
        map.replace(entity.getID(), entity);
    }

    @Override
    public void delete(TEntity entity) {
        if (!contains(entity)){
            return;
        }

        repository.delete(entity);
        map.remove(entity.getID());
    }

    private boolean contains(TEntity entity){
        return map.containsKey(entity.getID());
    }
}
