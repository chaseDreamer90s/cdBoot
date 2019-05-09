package com.dixn.dxboot.enable.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaCalServiceConditionConfig {

    @Bean(value = "java7CalculateService")
    @Conditional(Java7Condition.class)
    public Java7CalculateService java7CalculateService() {
        return new Java7CalculateService();
    }

 /*   @Bean
    @Conditional(Java8Condition.class)
    public Java8CalculateService java8CalculateService() {
        return new Java8CalculateService();
    }*/

}
