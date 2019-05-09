package com.dixn.dxboot.juc.vol;


class Vol {
    volatile int inc=0;
    void addTo40(){
        this.inc = 40;
    }
}

public class TestVolatile01 {

    public static void main(String[] args) {
        Vol vol = new Vol();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "come in");
                vol.addTo40();
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + vol.inc);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA").start();

        while (vol.inc == 0) {

        }
        System.out.println(Thread.currentThread().getName()+"---" + vol.inc);

    }
}
