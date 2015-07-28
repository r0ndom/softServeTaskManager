package com.softServe.taskManager.dao.impl.jdbc;

import com.softServe.taskManager.dao.GenericDao;
import com.softServe.taskManager.model.AbstractPersistenceObject;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class GenericDaoJdbcImpl<T extends AbstractPersistenceObject> implements GenericDao<T> {

    public abstract String getSelectQuery();

    public abstract String getDeleteQuery();

    public abstract String getFindAllQuery();

    public abstract RowMapper getMapper();

    //private BasicDataSource dataSource;
    protected JdbcTemplate jdbcTemplateObject;

    protected GenericDaoJdbcImpl(BasicDataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public T find(Long id) {
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
    public void delete(Long id){
        String SQL = getDeleteQuery();
        jdbcTemplateObject.update(SQL, id);
    }
}
