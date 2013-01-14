package com.apollo.mistar.controller;

import com.apollo.mistar.model.User;
import com.apollo.mistar.model.UserWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Copyright by Apollo Imaging Technology Pty Ltd.
 *
 * @Author: Hanmoi Daniel Choi
 * @Date : 14/01/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:TEST-META-INF/spring/test-root-context.xml",
        "classpath:TEST-META-INF/spring/test-mongo-context.xml"})
@WebAppConfiguration("classpath:/META-INF/spring/mvc/servlet-context.xml")
public class UserControllerTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void shouldAddNewUserToDB() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup((WebApplicationContext) applicationContext.getBean("webApplicationContext")).build();


        UserWrapper wrapper = new UserWrapper();
        User user = new User();
        user.setId("hanmoi@test.com");
        user.setName("test");
        user.setPassword("test");

        wrapper.setData(user);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(wrapper);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json.toString().getBytes());

        mockMvc.perform(requestBuilder).andDo(print());

    }
}
