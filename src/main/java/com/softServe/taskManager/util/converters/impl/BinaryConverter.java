package com.softServe.taskManager.util.converters.impl;

import com.softServe.taskManager.util.converters.Convertable;

import java.io.*;


public class BinaryConverter<T> implements Convertable<T> {

    @Override
    public void convert(T obj, String filePath) {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
        } catch(IOException i) {
            i.printStackTrace();
        }
    }

    @Override
    public Object deconvert(String filePath) {
        Object obj = null;
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            obj = (T) in.readObject();
            in.close();
            fileIn.close();
        } catch(IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
