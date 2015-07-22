package com.softServe.taskManager.service.impl;

import com.softServe.taskManager.dao.GenericDao;
import com.softServe.taskManager.dao.TaskDao;
import com.softServe.taskManager.model.Task;
import com.softServe.taskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl extends AbstractGenericServiceImpl<Task> implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    protected GenericDao<Task> getDao() {
        return taskDao;
    }
}
