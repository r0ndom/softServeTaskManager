package com.softserve.taskmanager.service;

import com.softServe.taskManager.dao.GenericDao;
import com.softServe.taskManager.dao.UserDao;
import com.softServe.taskManager.model.AbstractPersistenceObject;
import com.softServe.taskManager.model.User;
import com.softServe.taskManager.service.GenericService;
import com.softServe.taskManager.service.impl.UserServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;


public class UserServiceTest extends AbstractGenericServiceTest {
    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserDao userDao;


    @Override
    protected GenericService<AbstractPersistenceObject> getGenericService() {
        return (GenericService) userService;
    }

    @Override
    protected AbstractPersistenceObject getTestEntity() {
        User user = new User();
        user.setEmail("email@email.com");
        user.setPassword("password");
        return user;
    }

    @Override
    protected GenericDao<AbstractPersistenceObject> getGenericDao() {
        return (GenericDao) userDao;
    }
}
