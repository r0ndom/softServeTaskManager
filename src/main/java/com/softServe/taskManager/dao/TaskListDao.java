package com.softServe.taskManager.dao;


import com.softServe.taskManager.model.TaskList;

import java.util.List;

public interface TaskListDao extends GenericDao<TaskList> {
    public void create(List<TaskList> taskLists);

    public void update(List<TaskList> taskLists);
}
