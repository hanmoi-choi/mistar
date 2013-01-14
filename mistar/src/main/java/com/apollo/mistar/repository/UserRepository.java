package com.apollo.mistar.repository;

import com.apollo.mistar.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Copyright by Apollo Imaging Technology Pty Ltd.
 *
 * @Author: Hanmoi Daniel Choi
 * @Date : 3/01/13
 */
@Repository(value = "userRepository")
public class UserRepository implements GenericRepository<User, String> {
    private final String COLLECTION_NAME = "user";

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void add(User instance) {
        mongoTemplate.insert(instance);
    }

    @Override
    public void update(User instance) {
        mongoTemplate.save(instance);
    }

    @Override
    public void delete(User instance) {
    }

    @Override
    public User findById(String id) {
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)), User.class, COLLECTION_NAME);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void dropCollection() {
        mongoTemplate.dropCollection(COLLECTION_NAME);
    }

    @Override
    public int getConout() {
        return mongoTemplate.findAll(User.class).size();
    }
}
