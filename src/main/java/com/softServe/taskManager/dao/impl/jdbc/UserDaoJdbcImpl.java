package com.softServe.taskManager.dao.impl.jdbc;

import com.softServe.taskManager.dao.UserDao;
import com.softServe.taskManager.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mike on 7/14/2015.
 */
public class UserDaoJdbcImpl extends GenericDaoJdbcImpl<User> implements UserDao {
    @Override
    public String getSelectQuery() {
        return "SELECT id, name, surname, enrolment_date, group_id FROM daotalk.Student ";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO daotalk.Student (name, surname, enrolment_date, group_id) \n" + "VALUES (?, ?, ?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE daotalk.Student \n" + "SET name = ?, surname = ?, enrolment_date = ?, group_id = ? \n" + "WHERE id = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM daotalk.Student WHERE id= ?;";
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
//                student.setId(rs.getInt("id"));
//                student.setName(rs.getString("name"));
//                student.setSurname(rs.getString("surname"));
//                student.setEnrolmentDate(rs.getDate("enrolment_date"));
//                student.setGroupId(rs.getInt("group_id"));
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
//            Date sqlDate = convert(object.getEnrolmentDate());
//            statement.setString(1, object.getName());
//            statement.setString(2, object.getSurname());
//            statement.setDate(3, sqlDate);
//            statement.setInt(4, object.getGroupId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, User object) {
        try {
//            statement.setString(1, object.getName());
//            statement.setString(2, object.getSurname());
//            statement.setDate(3, convert(object.getEnrolmentDate()));
//            statement.setInt(4, object.getGroupId());
//            statement.setInt(5, object.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    protected java.sql.Date convert(java.util.Date date) {
        if (date == null) {
            return null;
        }
        return new java.sql.Date(date.getTime());
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
