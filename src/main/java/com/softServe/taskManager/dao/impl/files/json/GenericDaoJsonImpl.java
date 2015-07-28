package com.softServe.taskManager.dao.impl.files.json;


import com.softServe.taskManager.dao.GenericDao;
import com.softServe.taskManager.dao.impl.files.FilesUtilDao;
import com.softServe.taskManager.model.AbstractPersistenceObject;
import com.softServe.taskManager.util.converters.impl.JsonConverter;

import java.util.List;

public abstract class GenericDaoJsonImpl<T extends AbstractPersistenceObject> implements GenericDao<T> {

    protected FilesUtilDao<T> dao;

    protected GenericDaoJsonImpl(Class aClass) {
        this.dao = new FilesUtilDao<T>(new JsonConverter<T>(aClass), "db.json");
    }

    @Override
    public T create(T t) {
        dao.create(t);
        return t;
    }

    @Override
    public void delete(Long id){
        dao.delete(id);
    }

    @Override
    public T find(Long id){
        return dao.find(id);
    }

    @Override
    public T update(T t){
        dao.update(t);
        return t;
    }

    @Override
    public List<T> findAll(){
        return dao.findAll();
    }
}
