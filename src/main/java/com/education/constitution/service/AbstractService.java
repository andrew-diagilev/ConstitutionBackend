package com.education.constitution.service;

import com.education.constitution.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T, ID extends Serializable, R extends BaseRepository<T, ID>> implements BaseService<T, ID> {
    protected final R repository;

    @Autowired
    public AbstractService(R repository) {
        this.repository = repository;
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> getById(ID id) {
        return null;
    }

    @Override
    public T save(T entity) {
        return null;
    }

    @Override
    public List<T> saveAll(List<T> entityList) {
        return repository.saveAll(entityList);
    }

    @Override
    public void deleteById(ID id) {

    }
}

