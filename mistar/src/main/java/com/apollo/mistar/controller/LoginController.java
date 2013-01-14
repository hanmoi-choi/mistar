package com.apollo.mistar.controller;

import com.apollo.mistar.dto.UserConfig;
import com.apollo.mistar.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;


@Controller
public class LoginController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private UserService _userService;

    @Autowired
    public void setUserService(UserService userService){
        _userService = userService;
    }

    @RequestMapping("/")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/init", method = RequestMethod.POST)
    public ResponseEntity<UserConfig> initUserData(final Principal principal){
        final String userId = principal.getName();


        UserConfig config =  _userService.getUserConfig(userId);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<UserConfig>(config, httpHeaders, HttpStatus.OK);
    }
}
