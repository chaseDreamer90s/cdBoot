package com.dixn.dxboot.enable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2019-04-07 21:04
 **/
@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String helloWorld() {
        return "hello world";
    }
}
