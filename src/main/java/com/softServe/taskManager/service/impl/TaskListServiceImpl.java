package com.softServe.taskManager.service.impl;


import com.softServe.taskManager.model.TaskList;
import com.softServe.taskManager.service.TaskListService;
import com.softServe.taskManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskListServiceImpl implements TaskListService {

    @Autowired
    private UserService userService;

    @Override
    public TaskList create(TaskList object) {
        return null;
    }

    @Override
    public TaskList update(TaskList object) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public TaskList find(String id) {
        return null;
    }

    @Override
    public List<TaskList> findAll() {
        return null;
    }
}
