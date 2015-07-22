package com.softServe.taskManager.dao.impl.hibernate;


import com.softServe.taskManager.dao.TaskDao;
import com.softServe.taskManager.model.Task;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
public class TaskDaoHiberImpl extends GenericDaoHiberImpl<Task> implements TaskDao {
    @Override
    public void create(List<Task> tasks) {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();

        for ( int i = 0; i < tasks.size(); i++ ) {
            session.save(tasks.get(i));
            if ( i % 30 == 0 ) {
                session.flush();
                session.clear();
            }
        }
        tx.commit();
    }

    @Override
    public void update(List<Task> tasks) {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();

        for ( int i = 0; i < tasks.size(); i++ ) {
            session.merge(tasks.get(i));
            if ( i % 30 == 0 ) {
                session.flush();
                session.clear();
            }
        }
        tx.commit();

    }
}
