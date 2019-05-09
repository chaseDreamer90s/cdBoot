package com.dixn.dxboot.enable;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2019-04-07 21:54
 **/
public class OnSystemPropertyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        MultiValueMap<String, Object> allAnnotationAttributes = metadata.getAllAnnotationAttributes(ConditionOnSystemPorperty.class.getName());
        if (allAnnotationAttributes != null) {
            //String name = (String) allAnnotationAttributes.getFirst("name");
            String value = (String) allAnnotationAttributes.getFirst("value");

            if (value.equals("java7")) {
                return true;
            }
        }
        return false;
    }
}
