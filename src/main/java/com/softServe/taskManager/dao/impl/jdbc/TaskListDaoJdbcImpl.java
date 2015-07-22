package com.softServe.taskManager.dao.impl.jdbc;

import com.softServe.taskManager.dao.TaskListDao;
import com.softServe.taskManager.model.TaskList;
import com.softServe.taskManager.util.mappers.TaskListMapper;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * Created by Mike on 7/22/2015.
 */
public class TaskListDaoJdbcImpl extends GenericDaoJdbcImpl<TaskList> implements TaskListDao {
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
        return new TaskListMapper();
    }

    @Override
    public void create(List<TaskList> taskLists) {

    }

    @Override
    public void update(List<TaskList> taskLists) {

    }

    @Override
    public TaskList create(TaskList taskList) {
        return null;
    }

    @Override
    public TaskList update(TaskList taskList) {
        return null;
    }
}
