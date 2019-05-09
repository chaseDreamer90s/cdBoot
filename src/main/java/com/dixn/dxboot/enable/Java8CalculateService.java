package com.dixn.dxboot.enable;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2019-04-07 21:31
 **/
//@Profile("Java8")
//@Service
public class Java8CalculateService implements CalculateService {
    @Override
    public Integer sum(Integer... values) {
        int sum = Stream.of(values).reduce(0, Integer::sum);
        return sum;
    }
}
