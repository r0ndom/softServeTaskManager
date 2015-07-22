package com.softServe.taskManager.dao.impl.jdbc;

import com.softServe.taskManager.dao.GenericDao;
import com.softServe.taskManager.model.AbstractPersistenceObject;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public abstract class GenericDaoJdbcImpl<T extends AbstractPersistenceObject> implements GenericDao<T> {

    public abstract String getSelectQuery();

    public abstract String getDeleteQuery();

    public abstract String getFindAllQuery();

    public abstract RowMapper getMapper();

    @Autowired
    private BasicDataSource dataSource;
    protected JdbcTemplate jdbcTemplateObject;

    protected GenericDaoJdbcImpl() {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public T find(String id) {
        String SQL = getSelectQuery();
        T obj = (T) jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, getMapper());
        return obj;
    }

    @Override
    public List<T> findAll() {
        String SQL = getFindAllQuery();
        List <T> objects = jdbcTemplateObject.query(SQL, getMapper());
        return objects;
    }

    @Override
    public void delete(String id){
        String SQL = getDeleteQuery();
        jdbcTemplateObject.update(SQL, id);
    }
}
