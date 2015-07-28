package com.softServe.taskManager.util.mappers;

import com.softServe.taskManager.model.Task;
import com.softServe.taskManager.model.TaskList;
import com.softServe.taskManager.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("user_id"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        TaskList taskList = new TaskList();
        taskList.setId(rs.getLong("taskList_id"));
        taskList.setName(rs.getString(5));
        taskList.setUser(user);
        Task task = new Task();
        task.setId(rs.getLong(7));
        task.setName(rs.getString(8));
        task.setDeadline(rs.getDate("deadline"));
        task.setTaskList(taskList);
        ArrayList<TaskList> taskLists = new ArrayList<>();
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(task);
        taskList.setTasks(tasks);
        taskLists.add(taskList);
        user.setLists(taskLists);
        return user;
    }
}