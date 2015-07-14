package com.softServe.taskManager.dao.impl.mongodb.driver;


import com.softServe.taskManager.dao.TaskListDao;
import com.softServe.taskManager.dao.impl.mongodb.springData.GenericDaoSpringDataImpl;
import com.softServe.taskManager.model.TaskList;
import org.springframework.stereotype.Repository;

@Repository
public class TaskListDaoMongoDriverImpl extends GenericDaoMongoDriverImpl<TaskList> implements TaskListDao {
}
