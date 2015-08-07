package com.softServe.taskManager.dao.impl;


import com.softServe.taskManager.dao.TaskDao;
import com.softServe.taskManager.model.Task;
import com.softServe.taskManager.service.UserService;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("unchecked")
public class TaskDaoImpl extends GenericDaoImpl<Task> implements TaskDao {

    @Autowired
    private UserService userService;

    @Override
    public List<Task> list(Integer offset, Integer maxResults) {
        return getCurrentSession().createCriteria(Task.class)
                .add(Restrictions.eq("user_id", userService.getCurrentUser().getId()))
                .setFirstResult(offset!=null?offset:0)
                .setMaxResults(maxResults!=null?maxResults:5)
                .list();

    }

    @Override
    public Long count() {
        return (Long)getCurrentSession()
                .createCriteria(Task.class)
                .add(Restrictions.eq("user_id", userService.getCurrentUser().getId()))
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }
}
