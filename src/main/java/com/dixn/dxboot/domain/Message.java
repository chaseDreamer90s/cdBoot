package com.dixn.dxboot.domain;

import lombok.Data;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2019-01-17 14:01
 **/
@Data
public class Message {
    public static final Integer HELLO = 0;
    public static final Integer GOODBYE = 1;
    private String message;
    private Integer status;
}
