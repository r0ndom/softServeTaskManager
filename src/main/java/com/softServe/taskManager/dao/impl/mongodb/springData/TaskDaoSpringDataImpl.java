package com.softServe.taskManager.dao.impl.mongodb.springData;

import com.softServe.taskManager.dao.TaskDao;
import com.softServe.taskManager.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDaoSpringDataImpl extends GenericDaoSpringDataImpl<Task> implements TaskDao {
    public TaskDaoSpringDataImpl() {
        super(Task.class);
    }

    @Override
    public void create(List<Task> tasks) {
        mongoTemplate.insert(tasks, Task.class);
    }

    @Override
    public void update(List<Task> tasks) {
    }
}
