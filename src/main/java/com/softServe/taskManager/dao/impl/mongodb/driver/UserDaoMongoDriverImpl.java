package com.softServe.taskManager.dao.impl.mongodb.driver;


import com.softServe.taskManager.dao.UserDao;
import com.softServe.taskManager.dao.impl.mongodb.springData.GenericDaoSpringDataImpl;
import com.softServe.taskManager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoMongoDriverImpl extends GenericDaoMongoDriverImpl<User> implements UserDao {

    @Override
    public User create(User user) {
        user.setPassword(String.valueOf(user.getPassword().hashCode()));
        return super.create(user);
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public boolean isEmailExist(String email) {
        return findByEmail(email) != null;
    }
}
