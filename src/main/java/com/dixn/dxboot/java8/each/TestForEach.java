package com.dixn.dxboot.java8.each;

import java.util.Arrays;
import java.util.List;

public class TestForEach {

    public void testForEach() {
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features) {
            System.out.println(feature);
        }

        System.out.println("==========================");

        features.forEach(m -> System.out.println(m));
    }

    public static void main(String[] args) {
        TestForEach testForEach = new TestForEach();
        testForEach.testForEach();;
    }


}
