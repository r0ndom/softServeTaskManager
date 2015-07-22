package com.softServe.taskManager.dao.impl.files.xml;


import com.softServe.taskManager.dao.TaskDao;
import com.softServe.taskManager.model.Task;

import java.util.List;

public class TaskDaoXmlImpl extends GenericDaoXmlImpl<Task> implements TaskDao {
    @Override
    public void create(List<Task> tasks) {
        dao.create(tasks);
    }

    @Override
    public void update(List<Task> tasks) {
        dao.update(tasks);
    }
}
