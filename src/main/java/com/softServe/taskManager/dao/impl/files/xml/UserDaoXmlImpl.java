package com.softServe.taskManager.dao.impl.files.xml;


import com.softServe.taskManager.dao.UserDao;
import com.softServe.taskManager.model.User;

public class UserDaoXmlImpl extends GenericDaoXmlImpl<User> implements UserDao {

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
