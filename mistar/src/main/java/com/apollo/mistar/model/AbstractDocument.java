package com.apollo.mistar.model;

import org.springframework.data.annotation.Id;

import java.math.BigInteger;

/**
 * Copyright by Apollo Imaging Technology Pty Ltd.
 *
 * @Author: Hanmoi Daniel Choi
 * @Date : 10/01/13
 */
public class AbstractDocument {

    @Id
    private BigInteger _id;

    public BigInteger get_id() {
        return _id;
    }

    public void set_id(BigInteger _id) {
        this._id = _id;
    }
}
