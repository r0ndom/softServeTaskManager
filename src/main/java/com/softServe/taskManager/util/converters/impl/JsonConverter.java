package com.softServe.taskManager.util.converters.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.softServe.taskManager.util.converters.Convertable;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonConverter<T> implements Convertable<T> {

    private Class aClass;

    public JsonConverter(Class aClass) {
        this.aClass = aClass;
    }

    @Override
    public void convert(T obj, String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(filePath), obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object deconvert(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        Object obj = null;
        try {
            obj = mapper.readValue(new File(filePath),
                    mapper.getTypeFactory().constructCollectionType(List.class, aClass));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
