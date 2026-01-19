package com.research.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T> {
    void save(T entity);
    List<T> findAll();
    Optional<T> findById(int id);
    void delete(int id);
}
