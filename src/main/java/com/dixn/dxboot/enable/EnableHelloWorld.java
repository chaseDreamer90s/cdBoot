package com.dixn.dxboot.enable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2019-04-07 21:06
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(HelloWorldImportSelector.class)
public @interface EnableHelloWorld {
}
