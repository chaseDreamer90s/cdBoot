package com.dixn.dxboot.enable.autoconfig;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

public class Java7Condition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        MultiValueMap<String, Object> allAnnotationAttributes = metadata.getAllAnnotationAttributes(JavaOnSystemPorperty.class.getName());
        if (allAnnotationAttributes != null) {
            String value = (String) allAnnotationAttributes.getFirst("value");
            if (value.equals("java7")) {
                return true;
            }
        }
        return false;
    }
}
