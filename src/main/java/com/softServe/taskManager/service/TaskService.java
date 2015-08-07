package com.softServe.taskManager.service;


import com.softServe.taskManager.model.Task;

import java.util.List;

public interface TaskService extends GenericService<Task> {
    public Long addTask(Task task);

    public void editTask(Task task);

    public void deleteTask(Long id);

    public List<Task> list(Integer offset, Integer maxResults);

    public Long count();
}
