package com.softServe.taskManager.service;


import java.util.List;

public interface GenericService<T> {

    T create(T object);

    T update(T object);

    void delete(String id);

    T find(String id);

    List<T> findAll();

}
