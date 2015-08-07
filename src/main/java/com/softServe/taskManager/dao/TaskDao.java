package com.softServe.taskManager.dao;

import com.softServe.taskManager.model.Task;

import java.util.List;

public interface TaskDao extends GenericDao<Task> {

    public List<Task> list(Integer offset, Integer maxResults);

    public Long count();

}
