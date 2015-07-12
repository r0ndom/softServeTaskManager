package com.softServe.taskManager.dao;



import java.util.List;

public interface GenericDao<T> {

    T create(T t);

    void delete(String id);

    T find(String id);

    T update(T t);

    List<T> findAll();

}
