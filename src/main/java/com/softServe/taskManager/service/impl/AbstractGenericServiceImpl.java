package com.softServe.taskManager.service.impl;

import com.softServe.taskManager.dao.GenericDao;
import com.softServe.taskManager.model.AbstractPersistenceObject;
import com.softServe.taskManager.service.GenericService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public abstract class AbstractGenericServiceImpl<T extends AbstractPersistenceObject> implements GenericService<T> {

    abstract protected GenericDao<T> getDao();

    @Override
    public T create(T object) {
        return getDao().create(object);
    }

    @Override
    public T update(T object) {
        return getDao().update(object);
    }

    @Override
    public void delete(Long id) {
        getDao().delete(id);
    }

    @Override
    public T find(Long id) {
        return getDao().find(id);
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }
}
