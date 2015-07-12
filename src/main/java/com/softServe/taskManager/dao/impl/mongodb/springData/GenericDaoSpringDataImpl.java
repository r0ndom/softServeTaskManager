package com.softServe.taskManager.dao.impl.mongodb.springData;

import com.softServe.taskManager.dao.GenericDao;
import com.softServe.taskManager.model.AbstractPersistenceObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public abstract class GenericDaoSpringDataImpl<T extends AbstractPersistenceObject> implements GenericDao<T> {

    @Autowired
    private MongoTemplate mongoTemplate;

    private final Class<T> tClass;

    public GenericDaoSpringDataImpl(Class<T> tClass) {
        this.tClass = tClass;
    }

    @Override
    public T create(T t) {
        if (!mongoTemplate.collectionExists(tClass)) {
            mongoTemplate.createCollection(tClass);
        }
        mongoTemplate.insert(t, tClass.getSimpleName());
        return t;
    }

    @Override
    public void delete(String id){
        mongoTemplate.remove(Query.query(Criteria.where("id").is(id)), tClass.getSimpleName());
    }

    @Override
    public T find(String id){
        return mongoTemplate.findOne(Query.query(Criteria.where("id").is(id)), tClass, tClass.getSimpleName());
    }

    @Override
    public T update(T t){
        if (find(t.getId()) != null) {
            mongoTemplate.save(t, tClass.getSimpleName());
        }
        return t;
    }

    @Override
    public List<T> findAll(){
        return mongoTemplate.findAll(tClass, tClass.getSimpleName());
    }
}
