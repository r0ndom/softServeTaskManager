package com.softServe.taskManager.dao.impl.mongodb.driver;

import com.mongodb.*;
import com.softServe.taskManager.dao.GenericDao;
import com.softServe.taskManager.model.AbstractPersistenceObject;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;
import java.util.List;

@Component
public abstract class GenericDaoMongoDriverImpl <T extends AbstractPersistenceObject> implements GenericDao<T> {

    private DB db;

    protected GenericDaoMongoDriverImpl() {
        try {
            MongoClient mongo = new MongoClient( "localhost" , 27017 );
            this.db = mongo.getDB("test");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T create(T t) {
//        DBCollection table = db.getCollection("sdf");
//        BasicDBObject document = new BasicDBObject();
//        document.put("name", "mkyong");
//        document.put("age", 30);
//        table.insert(document);
        return null;
    }

    @Override
    public void delete(String id) {
//        DBCollection table = db.getCollection("user");
//
//        BasicDBObject searchQuery = new BasicDBObject();
//        searchQuery.put("name", "mkyong");
//
//        table.remove(searchQuery);
    }

    @Override
    public T find(String id) {
//        DBCollection table = db.getCollection("user");
//
//        BasicDBObject searchQuery = new BasicDBObject();
//        searchQuery.put("name", "mkyong");
//
//        DBCursor cursor = table.find(searchQuery);
//
//        while (cursor.hasNext()) {
//            System.out.println(cursor.next());
//        }
        return null;
    }

    @Override
    public T update(T t) {
//        DBCollection table = db.getCollection("user");
//
//        BasicDBObject query = new BasicDBObject();
//        query.put("name", "mkyong");
//
//        BasicDBObject newDocument = new BasicDBObject();
//        newDocument.put("name", "mkyong-updated");
//
//        BasicDBObject updateObj = new BasicDBObject();
//        updateObj.put("$set", newDocument);
//
//        table.update(query, updateObj);
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }
}
