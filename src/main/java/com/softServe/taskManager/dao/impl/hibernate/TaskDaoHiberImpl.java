package com.softServe.taskManager.dao.impl.hibernate;


import com.softServe.taskManager.dao.TaskDao;
import com.softServe.taskManager.model.Task;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class TaskDaoHiberImpl extends GenericDaoHiberImpl<Task> implements TaskDao {
}
