package com.dixn.dxboot.enable;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2019-04-07 21:09
 **/
@EnableHelloWorld
public class Test {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder(Test.class).web(WebApplicationType.NONE)
                .run(args);

        String helloWorld = context.getBean("helloWorld", String.class);

        System.out.println(helloWorld);

        context.close();

    }
}
