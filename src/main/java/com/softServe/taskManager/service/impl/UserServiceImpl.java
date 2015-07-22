package com.softServe.taskManager.service.impl;

import com.softServe.taskManager.dao.GenericDao;
import com.softServe.taskManager.dao.UserDao;
import com.softServe.taskManager.model.User;
import com.softServe.taskManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractGenericServiceImpl<User> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    protected GenericDao<User> getDao() {
        return userDao;
    }

    @Override
    public User create(User object) {
        object.setPassword(String.valueOf(object.getPassword().hashCode()));
        return userDao.create(object);
    }

    @Override
    public boolean isEmailExist(String email) {
        return userDao.isEmailExist(email);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User getCurrentUser() {
        return userDao.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
