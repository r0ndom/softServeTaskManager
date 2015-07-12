package com.softServe.taskManager.util.converters.impl;

import com.softServe.taskManager.util.converters.Convertable;
import com.thoughtworks.xstream.XStream;

import java.io.*;


public class XmlConverter<T> implements Convertable<T> {

    @Override
    public void convert(T obj, String filePath) {
        XStream xStream = new XStream();
        File file = new File(filePath);
        try {
            xStream.toXML(obj, new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Object deconvert(String filePath) {
        File file = new File(filePath);
        InputStream inputStream = null;
        Object obj = null;
        try {
            inputStream = new FileInputStream(file);
            XStream xStream = new XStream();
            obj = xStream.fromXML(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }
}
