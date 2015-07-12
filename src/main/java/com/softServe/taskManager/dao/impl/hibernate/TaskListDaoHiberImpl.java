package com.softServe.taskManager.dao.impl.hibernate;


import com.softServe.taskManager.dao.TaskListDao;
import com.softServe.taskManager.model.TaskList;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class TaskListDaoHiberImpl extends GenericDaoHiberImpl<TaskList> implements TaskListDao {
}
