package com.softServe.taskManager.util.converters;

public interface Convertable<T> {
    void convert(T obj, String filePath);
    Object deconvert(String filePath);
}
