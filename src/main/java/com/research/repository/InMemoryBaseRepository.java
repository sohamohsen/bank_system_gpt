package com.research.repository;

import java.util.*;

public abstract class InMemoryBaseRepository<T> implements BaseRepository<T> {

    protected Map<Integer, T> storage = new HashMap<>();

    @Override
    public void save(T entity) {
        storage.put(getId(entity), entity);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Optional<T> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public void delete(int id) {
        storage.remove(id);
    }

    protected abstract int getId(T entity);
}
