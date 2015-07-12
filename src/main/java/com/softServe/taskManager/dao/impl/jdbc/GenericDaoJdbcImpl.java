package com.softServe.taskManager.dao.impl.jdbc;

import com.softServe.taskManager.dao.GenericDao;
import com.softServe.taskManager.model.AbstractPersistenceObject;

import java.util.List;

public abstract class GenericDaoJdbcImpl<T extends AbstractPersistenceObject> implements GenericDao<T> {
    @Override
    public T create(T t) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public T find(String id) {
        return null;
    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }
}
