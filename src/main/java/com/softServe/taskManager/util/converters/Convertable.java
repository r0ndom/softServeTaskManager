package com.softServe.taskManager.util.converters;

import com.softServe.taskManager.model.AbstractPersistenceObject;

public interface Convertable<T> {
    void convert(T obj, String filePath);
    Object deconvert(String filePath);
}
