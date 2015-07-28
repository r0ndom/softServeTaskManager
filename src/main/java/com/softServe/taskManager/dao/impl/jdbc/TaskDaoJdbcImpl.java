package com.softServe.taskManager.dao.impl.jdbc;

import com.softServe.taskManager.dao.TaskDao;
import com.softServe.taskManager.model.Task;
import com.softServe.taskManager.model.TaskList;
import com.softServe.taskManager.util.mappers.TaskMapper;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Primary
@Repository
public class TaskDaoJdbcImpl extends GenericDaoJdbcImpl<Task> implements TaskDao {
    @Autowired
    protected TaskDaoJdbcImpl(BasicDataSource dataSource) {
        super(dataSource);
    }

    @Override
    public String getSelectQuery() {
        return getFindAllQuery().substring(0, getFindAllQuery().length()) + " where t.id = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM tdlist.task WHERE id = ?";
    }

    @Override
    public String getFindAllQuery() {
        return "SELECT t.* FROM tdlist.task t";
    }

    @Override
    public RowMapper getMapper() {
        return new TaskMapper();
    }

    @Override
    public void create(List<Task> tasks) {
        String SQL = "insert into tdlist.task (name, deadline, taskList_id) values (?, ?, ?)";
        List<Object[]> parameters = new ArrayList<Object[]>();

        for (Task task : tasks) {
            parameters.add(new Object[] {task.getId(),
                    task.getName(), task.getDeadline(), task.getTaskList().getId()});
        }
        jdbcTemplateObject.batchUpdate(SQL, parameters);
    }

    @Override
    public void update(List<Task> tasks) {
        String SQL = "update tdlist.task set name = ?, deadline = ? taskList_id = ? where id = ?";
        List<Object[]> parameters = new ArrayList<Object[]>();

        for (Task task : tasks) {
            parameters.add(new Object[] {task.getName(),
                    task.getDeadline(), task.getTaskList().getId(), task.getId()});
        }
        jdbcTemplateObject.batchUpdate(SQL, parameters);
    }

    @Override
    public Task create(Task task) {
        String SQL = "insert into tdlist.task (name, deadline, taskList_id) values (?, ?, ?)";
        jdbcTemplateObject.update(SQL, task.getId(), task.getName(),
                task.getDeadline(), task.getTaskList().getId());
        return task;
    }

    @Override
    public Task update(Task task) {
        String SQL = "update tdlist.task set name = ?, deadline = ? taskList_id = ? where id = ?";
        jdbcTemplateObject.update(SQL, task.getName(),
                task.getDeadline(), task.getTaskList().getId(), task.getId());
        return task;
    }
}
