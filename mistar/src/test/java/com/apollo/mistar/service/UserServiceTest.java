package com.apollo.mistar.service;

import com.apollo.mistar.model.User;
import com.apollo.mistar.repository.UserRepository;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Copyright by Apollo Imaging Technology Pty Ltd.
 *
 * @Author: Hanmoi Daniel Choi
 * @Date : 14/01/13
 */
public class UserServiceTest {

    @Test
    public void shouldGetUserObjIfThereisAUserMatched(){
        //given
        UserRepository mockUserRepository = mock(UserRepository.class);
        when(mockUserRepository.findById("hanmoi@test.com")).thenReturn(getUser());

        UserService sut = new UserService();
        sut.setUserRepository(mockUserRepository);

        //when
        User result = sut.checkCredential("hanmoi@test.com");

        assertThat(result).isNotNull().isEqualTo(getUser());
    }

    @Test
    public void shouldGetNullIfThereIsNoUserMatched(){
        //given
        UserRepository mockUserRepository = mock(UserRepository.class);
        when(mockUserRepository.findById("hanmoi@test.com")).thenReturn(getUser());
        when(mockUserRepository.findById("han@test.com")).thenReturn(null);

        UserService sut = new UserService();
        sut.setUserRepository(mockUserRepository);

        User result = sut.checkCredential("han@test.com");
        assertThat(result).isNull();
    }

    private User getUser() {
        User user = new User();
        user.setId("hanmoi@test.com");
        user.setName("hanmoi");
        user.setPassword("test");
        return user;
    }
}
