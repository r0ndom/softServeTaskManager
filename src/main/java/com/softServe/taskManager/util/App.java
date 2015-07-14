package com.softServe.taskManager.util;

import com.softServe.taskManager.dao.UserDao;
import com.softServe.taskManager.dao.impl.files.binary.UserDaoBinaryImpl;
import com.softServe.taskManager.dao.impl.files.json.UserDaoJsonImpl;
import com.softServe.taskManager.dao.impl.files.xml.UserDaoXmlImpl;
import com.softServe.taskManager.dao.impl.mongodb.springData.UserDaoSpringDataImpl;
import com.softServe.taskManager.model.Task;
import com.softServe.taskManager.model.TaskList;
import com.softServe.taskManager.model.User;
import com.softServe.taskManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
//        UserDao dao = new UserDaoJsonImpl();
//        dao.create(new User("sdf", "sdf", null));
//        dao.create(new User("wer", "wer", null));
//        System.out.println(dao.findAll());
    }
}
