package com.softServe.taskManager.dao;


import com.softServe.taskManager.model.User;

public interface UserDao extends GenericDao<User> {

    User findByEmail(String email);

    boolean isEmailExist(String email);

}
