package com.apollo.mistar.controller;

import com.apollo.mistar.dto.UserConfig;
import com.apollo.mistar.model.User;
import com.apollo.mistar.model.UserWrapper;
import com.apollo.mistar.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;


@RequestMapping("/user/")
@Controller
public class UserController {
//    private class UserWrapper extends RequestJSonWrapper<User>{}

    @Autowired
    UserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public @ResponseBody String addUser(@RequestBody UserWrapper wrapper){
        logger.debug("User: "+ wrapper.toString());

        User user = wrapper.getData();
        user.getRoles().add("ROLE_USER");
        userService.addUser(user);

        return "{ 'Status':'Success'}";
    }

    @RequestMapping(value = "changeConfig", method = RequestMethod.POST)
    public @ResponseBody String changeConfig(Principal principal, @RequestBody UserConfig userConfig){
        logger.debug("config: {}", userConfig.toString());

//        UserConfig userConfig = wrapper.getData();

        userService.changeUserConfig(principal.getName(), userConfig);

        return "{ 'Status':'Success'}";
    }

    @RequestMapping(value = "test")
    public  String test(){
        return "redirect:http://google.com";
    }


}
