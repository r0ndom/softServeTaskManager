package com.softServe.taskManager.dao.impl.files.json;


import com.softServe.taskManager.dao.UserDao;
import com.softServe.taskManager.model.User;

import java.util.List;

public class UserDaoJsonImpl extends GenericDaoJsonImpl<User> implements UserDao {

    public UserDaoJsonImpl() {
        super(User.class);
    }

    @Override
    public User findByEmail(String email) {
        for (User user : findAll()) {
            if (user.getEmail().equals(email))
                return user;
        }
        return null;
    }

    @Override
    public boolean isEmailExist(String email) {
        return findByEmail(email) != null;
    }
}
