package com.apollo.mistar.dto;


import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Copyright by Apollo Imaging Technology Pty Ltd.
 *
 * @Author: Hanmoi Daniel Choi
 * @Date : 4/01/13
 */
@JsonAutoDetect
public class LoginData {
    private String id;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
