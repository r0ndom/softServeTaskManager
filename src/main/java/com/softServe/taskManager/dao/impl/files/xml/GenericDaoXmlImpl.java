package com.softServe.taskManager.dao.impl.files.xml;


import com.softServe.taskManager.dao.GenericDao;
import com.softServe.taskManager.dao.impl.files.FilesUtilDao;
import com.softServe.taskManager.model.AbstractPersistenceObject;
import com.softServe.taskManager.util.converters.impl.XmlConverter;

import java.util.List;

public abstract class GenericDaoXmlImpl<T extends AbstractPersistenceObject> implements GenericDao<T> {

    protected FilesUtilDao<T> dao;

    protected GenericDaoXmlImpl() {
        this.dao = new FilesUtilDao<T>(new XmlConverter(), "db.xml");
    }

    @Override
    public T create(T t) {
        dao.create(t);
        return t;
    }

    @Override
    public void delete(String id){
        dao.delete(id);
    }

    @Override
    public T find(String id){
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
