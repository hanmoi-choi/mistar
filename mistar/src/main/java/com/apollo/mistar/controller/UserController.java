package com.apollo.mistar.controller;

import com.apollo.mistar.model.UserWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RequestMapping("/user/")
@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(method = RequestMethod.POST, value = "add")
    public @ResponseBody String post(@RequestBody UserWrapper userToAdd, HttpServletRequest request, HttpServletResponse response ){
        logger.info("hi");

        return "{ 'Status':'Success'}";
    }

    @RequestMapping(value = "test")
    public String test(){
        return "redirect:http://google.com";
    }
}
