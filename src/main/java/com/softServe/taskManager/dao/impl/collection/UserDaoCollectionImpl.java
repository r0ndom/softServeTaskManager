package com.softServe.taskManager.dao.impl.collection;


import com.softServe.taskManager.dao.UserDao;
import com.softServe.taskManager.model.User;

public class UserDaoCollectionImpl extends GenericDaoCollectionImpl<User> implements UserDao {

    @Override
    public User findByEmail(String email) {
        for (User user : storage) {
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
