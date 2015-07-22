package com.softServe.taskManager.dao;

import com.softServe.taskManager.model.Task;

import java.util.List;

public interface TaskDao extends GenericDao<Task> {

    public void create(List<Task> tasks);

    public void update(List<Task> tasks);

}
