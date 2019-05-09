package com.dixn.dxboot.enable.autoconfig;

import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2019-04-07 21:31
 **/
@Service
public class Java8CalculateService implements JavaCalculateService {
    @Override
    public Integer sum(Integer... values) {
        int sum = Stream.of(values).reduce(0, Integer::sum);
        return sum;
    }
}
