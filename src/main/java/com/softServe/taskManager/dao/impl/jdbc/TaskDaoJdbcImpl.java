package com.softServe.taskManager.dao.impl.jdbc;

import com.softServe.taskManager.dao.TaskDao;
import com.softServe.taskManager.model.Task;
import com.softServe.taskManager.util.mappers.TaskMapper;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class TaskDaoJdbcImpl extends GenericDaoJdbcImpl<Task> implements TaskDao {
    @Override
    public String getSelectQuery() {
        return null;
    }

    @Override
    public String getDeleteQuery() {
        return null;
    }

    @Override
    public String getFindAllQuery() {
        return null;
    }

    @Override
    public RowMapper getMapper() {
        return new TaskMapper();
    }

    @Override
    public void create(List<Task> tasks) {

    }

    @Override
    public void update(List<Task> tasks) {

    }

    @Override
    public Task create(Task task) {
        return null;
    }

    @Override
    public Task update(Task task) {
        return null;
    }
}
