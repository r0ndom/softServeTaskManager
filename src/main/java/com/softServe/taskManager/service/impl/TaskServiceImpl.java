package com.softServe.taskManager.service.impl;

import com.softServe.taskManager.dao.GenericDao;
import com.softServe.taskManager.model.Task;
import com.softServe.taskManager.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl extends AbstractGenericServiceImpl<Task> implements TaskService {

    @Override
    protected GenericDao<Task> getDao() {
        return null;
    }
}
