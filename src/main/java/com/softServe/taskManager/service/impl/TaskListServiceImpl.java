package com.softServe.taskManager.service.impl;


import com.softServe.taskManager.dao.GenericDao;
import com.softServe.taskManager.dao.TaskListDao;
import com.softServe.taskManager.model.TaskList;
import com.softServe.taskManager.service.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskListServiceImpl extends AbstractGenericServiceImpl<TaskList> implements TaskListService {

    @Autowired
    private TaskListDao taskListDao;

    @Override
    protected GenericDao<TaskList> getDao() {
        return taskListDao;
    }
}
