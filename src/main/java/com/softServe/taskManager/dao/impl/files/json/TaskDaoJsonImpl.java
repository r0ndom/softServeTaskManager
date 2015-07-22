package com.softServe.taskManager.dao.impl.files.json;


import com.softServe.taskManager.dao.TaskDao;
import com.softServe.taskManager.model.Task;

import java.util.List;

public class TaskDaoJsonImpl extends GenericDaoJsonImpl<Task> implements TaskDao {
    public TaskDaoJsonImpl() {
        super(Task.class);
    }

    @Override
    public void create(List<Task> tasks) {
        dao.create(tasks);
    }

    @Override
    public void update(List<Task> tasks) {
        dao.update(tasks);
    }
}
