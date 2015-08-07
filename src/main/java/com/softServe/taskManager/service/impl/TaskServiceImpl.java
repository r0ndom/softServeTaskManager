package com.softServe.taskManager.service.impl;

import com.softServe.taskManager.dao.GenericDao;
import com.softServe.taskManager.dao.TaskDao;
import com.softServe.taskManager.model.Task;
import com.softServe.taskManager.model.User;
import com.softServe.taskManager.service.TaskService;
import com.softServe.taskManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl extends AbstractGenericServiceImpl<Task> implements TaskService {

    @Autowired
    private TaskDao taskDao;
    @Autowired
    private UserService userService;

    @Override
    protected GenericDao<Task> getDao() {
        return taskDao;
    }

    @Override
    public Long addTask(Task task) {
        User user = userService.getCurrentUser();
        user.getTasks().add(task);
        userService.update(user);
        return task.getId();
    }

    @Override
    public void editTask(Task task) {
        taskDao.update(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskDao.delete(id);
    }

    @Override
    public List<Task> list(Integer offset, Integer maxResults){
        return taskDao.list(offset, maxResults);
    }

    @Override
    public Long count(){
        return taskDao.count();
    }
}
