package com.dixn.dxboot.juc.vol;


public class TestVolatile03 {
    public static void main(String[] args) throws Exception {
        PrimeGenerator gen = new PrimeGenerator();
        new Thread(gen).start();
        try {
            Thread.sleep(1000);
            System.out.println("over!!!!!!");
        } finally {
            gen.setCancelled(true);
        }
    }
}

class PrimeGenerator implements Runnable {
    private volatile boolean cancelled = false;
    @Override
    public void run() {
        while (!cancelled) {
            System.out.println("Running...");
        }
    }
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
