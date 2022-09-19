package com.mashibing.juc.c_012;

import java.util.concurrent.TimeUnit;

public class T {
    volatile boolean running = true;
    void m() {
        System.out.println("m start");
        while(running) {

        }
        System.out.println("end!");
    }

    public static void main(String[] args) {
        T t = new T();

        new Thread(t::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.running = false;
    }

}
