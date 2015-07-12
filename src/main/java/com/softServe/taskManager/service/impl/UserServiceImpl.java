package com.softServe.taskManager.service.impl;

import com.softServe.taskManager.dao.GenericDao;
import com.softServe.taskManager.dao.UserDao;
import com.softServe.taskManager.model.User;
import com.softServe.taskManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return userDao.create(object);
    }

    @Override
    public User update(User object) {
        return userDao.update(object);
    }

    @Override
    public void delete(String id) {
        userDao.delete(id);
    }

    @Override
    public User find(String id) {
        return userDao.find(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
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
