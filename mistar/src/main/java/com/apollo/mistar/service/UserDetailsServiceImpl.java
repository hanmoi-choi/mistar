package com.apollo.mistar.service;

import com.apollo.mistar.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Copyright by Apollo Imaging Technology Pty Ltd.
 *
 * @Author: Hanmoi Daniel Choi
 * @Date : 10/01/13
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserService _userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = _userService.checkCredential(email);

        if(user != null){
            UserDetailsImpl userDetailsImple = new UserDetailsImpl(user);
            return userDetailsImple;
        }
        else throw new UsernameNotFoundException("Could Not Found User with ID: "+email);
    }


    @Autowired
    public void setUserService(UserService userService){
        _userService = userService;
    }
}
