package com.softServe.taskManager.dao.impl.files;

import com.softServe.taskManager.dao.GenericDao;
import com.softServe.taskManager.model.AbstractPersistenceObject;
import com.softServe.taskManager.util.converters.Convertable;

import java.util.ArrayList;
import java.util.List;

public class FilesUtilDao<T extends AbstractPersistenceObject> implements GenericDao<T> {

    private final String dbName;
    private final Convertable converter;
    private List<T> storage;

    public FilesUtilDao(Convertable converter, String dbName) {
        this.dbName = dbName;
        this.converter = converter;
        List<T> tempList = (List<T>) converter.deconvert(dbName);
        if (tempList == null) {
            this.storage = new ArrayList<T>();
        } else {
            this.storage = tempList;
        }
    }

    @Override
    public T create(T t) {
        storage.add(t);
        converter.convert(storage, dbName);
        return t;
    }

    @Override
    public void delete(String id){
        T t = find(id);
        storage.remove(t);
        converter.convert(storage, dbName);
    }

    @Override
    public T find(String id){
        for (T t : storage) {
            if (t.getId().equals(id))
                return t;
        }
        return null;
    }

    @Override
    public T update(T t){
        delete(t.getId());
        create(t);
        converter.convert(storage, dbName);
        return t;
    }

    @Override
    public List<T> findAll(){
        return storage;
    }
}
