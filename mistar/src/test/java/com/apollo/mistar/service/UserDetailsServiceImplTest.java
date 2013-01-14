package com.apollo.mistar.service;

import com.apollo.mistar.model.User;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Copyright by Apollo Imaging Technology Pty Ltd.
 *
 * @Author: Hanmoi Daniel Choi
 * @Date : 14/01/13
 */
public class UserDetailsServiceImplTest {

    @Test
    public void shouldGetUserDetailsWithEmail(){
        UserService mockUserService = mock(UserService.class);
        when(mockUserService.checkCredential("hanmoi@test.com")).thenReturn(getUser());

        UserDetailsServiceImpl sut = new UserDetailsServiceImpl();
        sut.setUserService(mockUserService);

        UserDetails userDetails = sut.loadUserByUsername("hanmoi@test.com");

        assertThat(userDetails).isNotNull();

        assertThat(userDetails.getUsername()).isNotNull().isEqualTo("hanmoi@test.com");
        assertThat(userDetails.getPassword()).isNotNull();
        assertThat(userDetails.getAuthorities()).isNotNull();
    }

    private User getUser() {
        User user = new User();
        user.getRoles().add("ROLE_USER");
        user.setId("hanmoi@test.com");
        user.setName("hanmoi");
        user.setPassword("test");
        return user;
    }

}
