package com.dixn.dxboot.kafka;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2019-01-24 11:24
 **/
@Data
public class Message {
    private Long id;
    private String msg;
    private LocalDateTime sendTime;
}
