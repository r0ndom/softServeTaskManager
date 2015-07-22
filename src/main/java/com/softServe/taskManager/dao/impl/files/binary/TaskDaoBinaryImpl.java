package com.softServe.taskManager.dao.impl.files.binary;


import com.softServe.taskManager.dao.TaskDao;
import com.softServe.taskManager.model.Task;

import java.util.List;

public class TaskDaoBinaryImpl extends GenericDaoBinaryImpl<Task> implements TaskDao {
    @Override
    public void create(List<Task> tasks) {
        dao.create(tasks);
    }

    @Override
    public void update(List<Task> tasks) {
        dao.update(tasks);
    }
}
