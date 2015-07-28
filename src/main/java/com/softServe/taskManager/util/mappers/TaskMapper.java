package com.softServe.taskManager.util.mappers;


import com.softServe.taskManager.model.Task;
import com.softServe.taskManager.service.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TaskMapper implements RowMapper<Task> {

    @Autowired
    private TaskListService taskListService;

    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        Task task = new Task();
        task.setId(rs.getLong("id"));
        task.setDeadline(rs.getDate("deadline"));
        task.setName(rs.getString("name"));
        task.setTaskList(taskListService.find(rs.getLong("taskList_id")));
        return task;
    }
}
