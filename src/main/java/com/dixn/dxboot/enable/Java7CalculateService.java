package com.dixn.dxboot.enable;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2019-04-07 21:31
 **/
//@Profile("Java7")
//@Service
public class Java7CalculateService implements CalculateService {
    @Override
    public Integer sum(Integer... values) {
        int sum = 0;
        for (int i=0; i<values.length; i++) {
            sum+=values[i];
        }
        return sum;
    }
}
