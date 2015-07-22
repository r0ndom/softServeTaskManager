package com.softServe.taskManager.service.impl;


import com.softServe.taskManager.dao.GenericDao;
import com.softServe.taskManager.model.TaskList;
import com.softServe.taskManager.service.TaskListService;
import org.springframework.stereotype.Service;

@Service
public class TaskListServiceImpl extends AbstractGenericServiceImpl<TaskList> implements TaskListService {



    @Override
    protected GenericDao<TaskList> getDao() {
        return null;
    }
}
