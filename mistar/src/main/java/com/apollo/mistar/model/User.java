package com.apollo.mistar.model;


import org.codehaus.jackson.annotate.JsonAutoDetect;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonAutoDetect
public class User {

    @NotNull
    @Size(max = 50)
    private String id;

    @NotNull
    @Size(max = 50)
    private String name;

    @NotNull
    private String password;

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
