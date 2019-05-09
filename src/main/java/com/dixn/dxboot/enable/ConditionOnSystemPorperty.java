package com.dixn.dxboot.enable;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2019-04-07 21:53
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionOnSystemPorperty {

    String value();
}
