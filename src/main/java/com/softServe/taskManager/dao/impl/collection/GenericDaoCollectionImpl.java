package com.softServe.taskManager.dao.impl.collection;

import com.softServe.taskManager.dao.GenericDao;
import com.softServe.taskManager.model.AbstractPersistenceObject;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericDaoCollectionImpl<T extends AbstractPersistenceObject> implements GenericDao<T> {

    protected List<T> storage;

    protected GenericDaoCollectionImpl() {
        this.storage = new ArrayList<T>();
    }

    @Override
    public T create(T t) {
        storage.add(t);
        return t;
    }

    @Override
    public void delete(Long id){
        T t = find(id);
        storage.remove(t);
    }

    @Override
    public T find(Long id){
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
        return t;
    }

    @Override
    public List<T> findAll(){
        return storage;
    }
}
