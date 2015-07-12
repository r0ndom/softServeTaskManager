package com.softServe.taskManager.dao.impl.mongodb.springData;

import com.softServe.taskManager.dao.TaskDao;
import com.softServe.taskManager.model.Task;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDaoSpringDataImpl extends GenericDaoSpringDataImpl<Task> implements TaskDao {
    public TaskDaoSpringDataImpl() {
        super(Task.class);
    }
}
