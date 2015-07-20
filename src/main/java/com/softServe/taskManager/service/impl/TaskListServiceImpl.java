package com.softServe.taskManager.service.impl;


import com.softServe.taskManager.dao.GenericDao;
import com.softServe.taskManager.model.TaskList;
import com.softServe.taskManager.service.TaskListService;
import com.softServe.taskManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskListServiceImpl extends AbstractGenericServiceImpl<TaskList> implements TaskListService {



    @Override
    protected GenericDao<TaskList> getDao() {
        return null;
    }
}
