package com.dixn.dxboot.enable.autoconfig;

import org.springframework.boot.WebApplicationType;
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

@ComponentScan(basePackages = "com.dixn.dxboot.enable.autoconfig")
@JavaOnSystemPorperty(value = "java7")
public class Test3 {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(Test3.class).web(WebApplicationType.NONE)
                .run(args);

        JavaCalculateService bean = context.getBean(JavaCalculateService.class);

        System.out.println(bean.sum(1,2,3,4));

        context.close();

    }
}
