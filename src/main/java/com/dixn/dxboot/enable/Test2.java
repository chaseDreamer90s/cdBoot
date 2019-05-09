package com.dixn.dxboot.enable;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2019-04-07 21:37
 **/
//@SpringBootApplication(scanBasePackages = "com.dixn.dxboot.enable")

@ComponentScan(basePackages = "com.dixn.dxboot.enable")
@ConditionOnSystemPorperty(value = "java7")
public class Test2 {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(Test2.class).web(WebApplicationType.NONE)
                //.profiles("Java8")
                .run(args);

        CalculateService bean = context.getBean(CalculateService.class);

        System.out.println(bean.sum(1,2,3,4));

        context.close();

    }
}
