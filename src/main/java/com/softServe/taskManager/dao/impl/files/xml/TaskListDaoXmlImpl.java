package com.softServe.taskManager.dao.impl.files.xml;


import com.softServe.taskManager.dao.TaskListDao;
import com.softServe.taskManager.model.TaskList;

import java.util.List;

public class TaskListDaoXmlImpl extends GenericDaoXmlImpl<TaskList> implements TaskListDao {
    @Override
    public void create(List<TaskList> taskLists) {
        dao.create(taskLists);
    }

    @Override
    public void update(List<TaskList> taskLists) {
        dao.update(taskLists);
    }
}
