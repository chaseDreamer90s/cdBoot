package com.dixn.dxboot.java8.thread;

public class TestThread {

    public void runProcess() {
        new Thread(() -> {
            System.out.printf("thread name : %s \n" , Thread.currentThread().getName());
        }).start();
    }

    public static void main(String[] args) {
        for (int i=0; i<10 ;i++) {
            TestThread testThread = new TestThread();
            testThread.runProcess();
        }
    }

}
