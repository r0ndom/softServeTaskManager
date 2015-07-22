package com.softServe.taskManager.dao.impl.hibernate;


import com.softServe.taskManager.dao.TaskListDao;
import com.softServe.taskManager.model.TaskList;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
public class TaskListDaoHiberImpl extends GenericDaoHiberImpl<TaskList> implements TaskListDao {
    @Override
    public void create(List<TaskList> taskLists) {

    }

    @Override
    public void update(List<TaskList> taskLists) {

    }
}
