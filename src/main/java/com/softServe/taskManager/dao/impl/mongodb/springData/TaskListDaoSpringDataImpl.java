package com.softServe.taskManager.dao.impl.mongodb.springData;


import com.softServe.taskManager.dao.TaskListDao;
import com.softServe.taskManager.model.TaskList;
import org.springframework.stereotype.Repository;

@Repository
public class TaskListDaoSpringDataImpl extends GenericDaoSpringDataImpl<TaskList> implements TaskListDao {
    public TaskListDaoSpringDataImpl() {
        super(TaskList.class);
    }
}
