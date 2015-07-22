package com.softServe.taskManager.util.mappers;

import com.softServe.taskManager.model.TaskList;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class TaskListMapper implements RowMapper<TaskList> {
    @Override
    public TaskList mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
