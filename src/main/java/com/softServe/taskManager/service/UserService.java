package com.softServe.taskManager.service;


import com.softServe.taskManager.model.User;

public interface UserService extends  GenericService<User> {

    public boolean isEmailExist(String email);

    User findByEmail(String email);

    User getCurrentUser();
}
