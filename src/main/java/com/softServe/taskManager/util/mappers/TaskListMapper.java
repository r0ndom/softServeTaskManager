package com.softServe.taskManager.util.mappers;

import com.softServe.taskManager.model.Task;
import com.softServe.taskManager.model.TaskList;
import com.softServe.taskManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class TaskListMapper implements RowMapper<TaskList> {

    @Autowired
    private UserService userService;

    @Override
    public TaskList mapRow(ResultSet rs, int rowNum) throws SQLException {
        TaskList taskList = new TaskList();
        taskList.setId(rs.getLong(1));
        taskList.setName(rs.getString(2));
        taskList.setUser(userService.find(rs.getLong("user_id")));
        Task task = new Task();
        task.setId(rs.getLong(4));
        task.setName(rs.getString(5));
        task.setDeadline(rs.getDate("deadline"));
        task.setTaskList(taskList);
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(task);
        taskList.setTasks(tasks);
        return taskList;
    }
}
