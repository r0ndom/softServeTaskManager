package com.softServe.taskManager.dao.impl.files.json;


import com.softServe.taskManager.dao.TaskListDao;
import com.softServe.taskManager.model.TaskList;

import java.util.List;

public class TaskListDaoJsonImpl extends GenericDaoJsonImpl<TaskList> implements TaskListDao {
    public TaskListDaoJsonImpl() {
        super(TaskList.class);
    }

    @Override
    public void create(List<TaskList> taskLists) {
        dao.create(taskLists);
    }

    @Override
    public void update(List<TaskList> taskLists) {
        dao.update(taskLists);
    }
}
