package com.softServe.taskManager.dao.impl.files.json;


import com.softServe.taskManager.dao.TaskDao;
import com.softServe.taskManager.model.Task;

public class TaskDaoJsonImpl extends GenericDaoJsonImpl<Task> implements TaskDao {
    public TaskDaoJsonImpl() {
        super(Task.class);
    }
}
