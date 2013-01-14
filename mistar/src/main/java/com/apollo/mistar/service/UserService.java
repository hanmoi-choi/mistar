package com.apollo.mistar.service;

import com.apollo.mistar.dto.UserConfig;
import com.apollo.mistar.model.User;
import com.apollo.mistar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright by Apollo Imaging Technology Pty Ltd.
 *
 * @Author: Hanmoi Daniel Choi
 * @Date : 3/01/13
 */
@Service(value = "userService")
public class UserService {
    UserRepository _userRepository;

    public void addUser(User newUser){
        _userRepository.add(newUser);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        _userRepository = userRepository;
    }

    public User checkCredential(String userId){
        return _userRepository.findById(userId);
    }

    public void changeUserConfig(String name, UserConfig userConfig) {
        User user = _userRepository.findById(name);
        user.setUserConfig(userConfig);
        _userRepository.update(user);
    }

    public UserConfig getUserConfig(String userId) {
        User user = _userRepository.findById(userId);
        return user.getUserConfig();
    }
}
