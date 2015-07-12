package com.softServe.taskManager.dao.impl.files.json;


import com.softServe.taskManager.dao.TaskListDao;
import com.softServe.taskManager.model.TaskList;

public class TaskListDaoJsonImpl extends GenericDaoJsonImpl<TaskList> implements TaskListDao {
    public TaskListDaoJsonImpl() {
        super(TaskList.class);
    }
}
