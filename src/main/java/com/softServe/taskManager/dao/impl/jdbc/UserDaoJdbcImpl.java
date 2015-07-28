package com.softServe.taskManager.dao.impl.jdbc;

import com.softServe.taskManager.dao.TaskDao;
import com.softServe.taskManager.dao.TaskListDao;
import com.softServe.taskManager.dao.UserDao;
import com.softServe.taskManager.model.TaskList;
import com.softServe.taskManager.model.User;
import com.softServe.taskManager.util.mappers.UserMapper;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
public class UserDaoJdbcImpl extends GenericDaoJdbcImpl<User> implements UserDao {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private TaskListDao taskListDao;

    @Autowired
    protected UserDaoJdbcImpl(BasicDataSource dataSource) {
        super(dataSource);
    }

    @Override
    public String getSelectQuery() {
        return getFindAllQuery().substring(0, getFindAllQuery().length()) + " where u.id = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM tdlist.user WHERE id = ?";
    }

    @Override
    public String getFindAllQuery() {
        return "SELECT u.*, tl.*, t.* FROM tdlist.user u LEFT JOIN tdlist.taskList " +
                "tl on u.id=tl.user_id LEFT JOIN tdlist.task t on tl.id = t.taskList_id";
    }

    @Override
    public RowMapper getMapper() {
        return new UserMapper();
    }

    @Override
    public User create(User user) {
        String SQL = "insert into tdlist.user (email, password) values (?, ?)";
        jdbcTemplateObject.update( SQL, user.getEmail(), user.getPassword());
        List<TaskList> list = user.getLists();
        if (list != null) {
            taskListDao.create(list);
            for (TaskList taskList : list) {
                taskDao.create(taskList.getTasks());
            }
        }
        return user;
    }

    @Override
    public User update(User user) {
        String SQL = "update tdlist.user set email = ?, password = ? where id = ?";
        jdbcTemplateObject.update(SQL, user.getEmail(), user.getPassword(), user.getId());
        List<TaskList> list = user.getLists();
        taskListDao.update(list);
        for (TaskList taskList : list) {
            taskDao.update(taskList.getTasks());
        }
        return user;
    }

    @Override
    public User findByEmail(String email) {
        String SQL = getFindAllQuery().substring(0, getFindAllQuery().length()) + " where u.email = ?";
        return (User) jdbcTemplateObject.queryForObject(SQL, new Object[]{email}, getMapper());
    }

    @Override
    public boolean isEmailExist(String email) {
        return findByEmail(email) != null;
    }

}