package com.softServe.taskManager.dao.impl.mongodb.springData;


import com.softServe.taskManager.dao.UserDao;
import com.softServe.taskManager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoSpringDataImpl extends GenericDaoSpringDataImpl<User> implements UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public UserDaoSpringDataImpl() {
        super(User.class);
    }

    @Override
    public User findByEmail(String email) {
        return mongoTemplate.findOne(Query.query(Criteria.where("email").is(email)), User.class, User.class.getSimpleName());
    }

    @Override
    public boolean isEmailExist(String email) {
        return findByEmail(email) != null;
    }
}
