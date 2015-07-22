package com.softServe.taskManager.dao.impl.files.binary;


import com.softServe.taskManager.dao.TaskListDao;
import com.softServe.taskManager.model.TaskList;

import java.util.List;

public class TaskListDaoBinaryImpl extends GenericDaoBinaryImpl<TaskList> implements TaskListDao {
    @Override
    public void create(List<TaskList> taskLists) {
        dao.create(taskLists);
    }

    @Override
    public void update(List<TaskList> taskLists) {
        dao.update(taskLists);
    }
}
