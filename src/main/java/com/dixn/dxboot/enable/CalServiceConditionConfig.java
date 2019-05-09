package com.dixn.dxboot.enable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalServiceConditionConfig {

    @Bean(value = "java7CalculateService")
    @Conditional(OnSystemPropertyCondition.class)
    public Java7CalculateService java7CalculateService() {
        return new Java7CalculateService();
    }

    @Bean(value = "java8CalculateService")
    @Conditional(OnSystemPropertyCondition8.class)
    public Java8CalculateService java8CalculateService() {
        return new Java8CalculateService();
    }

}
