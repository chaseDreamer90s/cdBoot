package com.dixn.dxboot.enable.autoconfig;

import org.springframework.stereotype.Service;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2019-04-07 21:31
 **/
public class Java7CalculateService implements JavaCalculateService {
    @Override
    public Integer sum(Integer... values) {
        int sum = 0;
        for (int i=0; i<values.length; i++) {
            sum+=values[i];
        }
        return sum;
    }
}
