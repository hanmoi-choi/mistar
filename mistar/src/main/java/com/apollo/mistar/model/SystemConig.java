package com.apollo.mistar.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Copyright by Apollo Imaging Technology Pty Ltd.
 *
 * @Author: Hanmoi Daniel Choi
 * @Date : 3/01/13
 */
@Document
public class SystemConig {
    @Id
    private String id;

    private String bgImage;


}
