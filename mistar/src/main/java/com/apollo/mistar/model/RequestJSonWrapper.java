package com.apollo.mistar.model;

/**
 * Copyright by Apollo Imaging Technology Pty Ltd.
 *
 * @Author: Hanmoi Daniel Choi
 * @Date : 4/01/13
 */
public class RequestJSonWrapper <JSON_TYPE> {
    private JSON_TYPE data;

    public JSON_TYPE getData() {
        return data;
    }

    public void setData(JSON_TYPE data) {
        this.data = data;
    }
}
