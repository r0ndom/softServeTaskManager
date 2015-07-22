package com.softServe.taskManager.dao.impl.hibernate;

import com.softServe.taskManager.dao.GenericDao;
import com.softServe.taskManager.model.AbstractPersistenceObject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Component
@SuppressWarnings("unchecked")
public abstract class GenericDaoHiberImpl<T extends AbstractPersistenceObject> implements GenericDao<T> {

    @Autowired
    private SessionFactory sessionFactory;
    private Class<T> type;

    public GenericDaoHiberImpl() {
        final Type t = getClass().getGenericSuperclass();
        final ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public T create(final T t) {
        getCurrentSession().save(t);
        return t;
    }

    @Override
    public void delete(final String id) {
        getCurrentSession().delete(find(id));
    }

    @Override
    public T find(final String id) {
        return (T) getCurrentSession().get(type, id);
    }

    @Override
    public T update(final T t) {
        getCurrentSession().merge(t);
        return t;
    }

    @Override
    public List<T> findAll() {
        return getCurrentSession().createCriteria(type).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
}
