package com.softServe.taskManager.dao.impl.jdbc;

import com.softServe.taskManager.dao.TaskDao;
import com.softServe.taskManager.dao.TaskListDao;
import com.softServe.taskManager.model.Task;
import com.softServe.taskManager.model.TaskList;
import com.softServe.taskManager.util.mappers.TaskListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskListDaoJdbcImpl extends GenericDaoJdbcImpl<TaskList> implements TaskListDao {

    @Autowired
    private TaskDao taskDao;

    @Override
    public String getSelectQuery() {
        return getFindAllQuery().substring(0, getFindAllQuery().length() - 1) + " where tl.id = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM tdlist.taskList WHERE id = ?";
    }

    @Override
    public String getFindAllQuery() {
        return "SELECT tl.*, t.* FROM tdlist.taskList tl LEFT JOIN tdlist.task t on tl.id=t.taskList_id";
    }

    @Override
    public RowMapper getMapper() {
        return new TaskListMapper();
    }

    @Override
    public void create(List<TaskList> taskLists) {
        String SQL = "insert into tdlist.taskList (id, name, user_id) values (?, ?, ?)";
        List<Object[]> parameters = new ArrayList<Object[]>();

        for (TaskList taskList : taskLists) {
            parameters.add(new Object[] {taskList.getId(),
                            taskList.getName(), taskList.getUser().getId()});
        }
        jdbcTemplateObject.batchUpdate(SQL, parameters);
    }

    @Override
    public void update(List<TaskList> taskLists) {
        String SQL = "update tdlist.taskList set name = ?, user_id = ? where id = ?";
        List<Object[]> parameters = new ArrayList<Object[]>();

        for (TaskList taskList : taskLists) {
            parameters.add(new Object[] {taskList.getName(),
                    taskList.getUser().getId(), taskList.getId()});
        }
        jdbcTemplateObject.batchUpdate(SQL, parameters);
    }

    @Override
    public TaskList create(TaskList taskList) {
        String SQL = "insert into tdlist.taskList (id, name, user_id) values (?, ?, ?)";
        jdbcTemplateObject.update(SQL, taskList.getId(), taskList.getName(), taskList.getUser().getId());
        taskDao.create(taskList.getTasks());
        return taskList;
    }

    @Override
    public TaskList update(TaskList taskList) {
        String SQL = "update tdlist.taskList set name = ?, user_id = ? where id = ?";
        jdbcTemplateObject.update(SQL, taskList.getName(), taskList.getUser().getId(), taskList.getId());
        taskDao.update(taskList.getTasks());
        return taskList;
    }
}
