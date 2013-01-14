package com.apollo.mistar.repository;

import com.apollo.mistar.model.User;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Copyright by Apollo Imaging Technology Pty Ltd.
 *
 * @Author: Hanmoi Daniel Choi
 * @Date : 10/01/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:TEST-META-INF/spring/test-root-context.xml",
        "classpath:TEST-META-INF/spring/test-mongo-context.xml"})
public class UserRopsitoryTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired UserRepository repository;

    @Test
    public void couldPersistUserObjToDB(){

        User user = getUser();

        repository.add(user);
        assertThat(user.getId()).isNotNull();
        assertThat(repository.getConout()).isEqualTo(1);
    }

    @Test
    public void couldGetUserById(){
        User testUser = getUser();

        repository.add(testUser);
        User result = repository.findById(testUser.getId());

        assertThat(result).isNotNull()
                .isInstanceOf(User.class)
                .isEqualTo(testUser);

    }

    private User getUser() {
        User user = new User();
        user.setId("hanmoi@test.com");
        user.setName("hanmoi");
        user.setPassword("test");
        return user;
    }

    @After
    public void tearDown(){
        logger.debug("here");
        repository.dropCollection();
    }
}
