package com.softServe.taskManager.dao.impl.jdbc;

import com.softServe.taskManager.dao.UserDao;
import com.softServe.taskManager.model.Task;
import com.softServe.taskManager.model.TaskList;
import com.softServe.taskManager.model.User;
import com.sun.javafx.tk.Toolkit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mike on 7/14/2015.
 *
 */
public class UserDaoJdbcImpl extends GenericDaoJdbcImpl<User> implements UserDao {
    @Override
    public String getSelectQuery() {
//        return "SELECT u.*, tl.*, t.* FROM tdlist.user u INNER JOIN tdlist.taskList tl INNER JOIN tdlist.task t";
        return "SELECT u.*, tl.*, t.* FROM tdlist.user u INNER JOIN tdlist.taskList tl INNER JOIN tdlist.task t WHERE u.id = tl.user_id AND tl.id = t.tasklist_id;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO tdlist.user \n" + "VALUES (?, ?, ?);"
                + "INSERT INTO tdlist.taskList \n" + "VALUES(?, ?, ?);"
                + "INSERT INTO tdlist.task \n" + "VALUES(?, ?, ?, ?);";

//        return "INSERT INTO tdlist.user (email, password) \n" + "VALUES (?, ?);"
//                + "INSERT INTO tdlist.taskList (name, user_id) \n" + "VALUES(?, ?);"
//                + "INSERT INTO tdlist.task (name, taskDate, taskList_id) \n" + "VALUES(?, ?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE tdlist.user \n" + "SET email = ?, password = ? \n" + "WHERE id = ?;"
                + "UPDATE tdlist.taskList \n" + "SET name = ?, user_id = ? \n" + "WHERE id = ?;"
                + "UPDATE tdlist.task \n" + "SET name = ?, taskDate = ?, taskList_id = ? \n" + "WHERE id = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM tdlist.user WHERE id = ?;"
                + "DELETE FROM tdlist.taskList WHERE id = ?;"
                + "DELETE FROM tdlist.task WHERE id = ?;";
    }

    public UserDaoJdbcImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected List<User> parseResultSet(ResultSet rs) {
        LinkedList<User> result = new LinkedList<User>();
        try {
            while (rs.next()) {
                User user = new User();
                String userId = rs.getString("id");
                user.setId(userId);
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                result.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, User object) {
        try {
            statement.setString(1, object.getId());
            statement.setString(2, object.getEmail());
            statement.setString(3, object.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, User object) {
        try {
            statement.setString(1, object.getId());
            statement.setString(2, object.getEmail());
            statement.setString(3, object.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public boolean isEmailExist(String email) {
        return false;
    }
}