package com.softServe.taskManager.dao.impl.jdbc;

import com.softServe.taskManager.dao.GenericDao;
import com.softServe.taskManager.model.AbstractPersistenceObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public abstract class GenericDaoJdbcImpl<T extends AbstractPersistenceObject> implements GenericDao<T> {
    private Connection connection;

    public abstract String getSelectQuery();

    public abstract String getCreateQuery();

    public abstract String getUpdateQuery();

    public abstract String getDeleteQuery();

    protected abstract List<T> parseResultSet(ResultSet rs);

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object);

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object);

    @Override
    public T find(String key){
        List<T> list = null;
        String sql = getSelectQuery();
        sql += " WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, key);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.iterator().next();
    }

    @Override
    public List<T> findAll() {
        List<T> list = null;
        String sql = getSelectQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public T create(T object){
        String sql = getCreateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForInsert(statement, object);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public T update(T object) {
        String sql = getUpdateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            prepareStatementForUpdate(statement, object);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public void delete(String id) {
        T object = find(id);
        String sql = getDeleteQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try {
                statement.setObject(1, object.getId());
            } catch (Exception e) {
                throw new SQLException(e);
            }
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new SQLException("On delete modify more then 1 record: " + count);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GenericDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }
}
