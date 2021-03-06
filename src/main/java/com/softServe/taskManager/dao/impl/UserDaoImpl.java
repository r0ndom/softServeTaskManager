package com.softServe.taskManager.dao.impl;


import com.softServe.taskManager.dao.UserDao;
import com.softServe.taskManager.model.User;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
    public static final String EMAIL_STRING = "email";

    @Override
    public User findByEmail(final String email) {
        return (User) getCurrentSession().createCriteria(User.class).add(Restrictions.eq(EMAIL_STRING, email)).uniqueResult();
    }

    @Override
    public boolean isEmailExist(String email) {
        final int count = ((Long) getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq(EMAIL_STRING, email))
                .setProjection(Projections.rowCount()).uniqueResult()).intValue();
        return count != 0;
    }
}
