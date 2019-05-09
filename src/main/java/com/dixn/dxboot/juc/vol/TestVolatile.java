package com.dixn.dxboot.juc.vol;


import java.util.concurrent.atomic.AtomicInteger;

public class TestVolatile {

    public AtomicInteger inc = new AtomicInteger(0);

    public void increase() {
        inc.getAndIncrement();
    }

    public static void main(String[] args) {
        final TestVolatile vol = new TestVolatile();

        for (int i=0; i<10; i++) {
            new Thread(() -> {
                for (int j=0; j<100; j++) {
                    vol.increase();
                }
            }, "AAA").start();
        }

        while(Thread.activeCount()>1) {
            Thread.yield();
        }
        System.out.println(vol.inc);

    }
}
