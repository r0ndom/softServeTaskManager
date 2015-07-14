package com.softServe.taskManager.dao.impl.mongodb.driver;

import com.softServe.taskManager.dao.TaskDao;
import com.softServe.taskManager.dao.impl.mongodb.springData.GenericDaoSpringDataImpl;
import com.softServe.taskManager.model.Task;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDaoMongoDriverImpl extends GenericDaoMongoDriverImpl<Task> implements TaskDao {
}
