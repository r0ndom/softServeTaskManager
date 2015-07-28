package com.softServe.taskManager.dao;



import java.util.List;

public interface GenericDao<T> {

    T create(T t);

    void delete(Long id);

    T find(Long id);

    T update(T t);

    List<T> findAll();

}
