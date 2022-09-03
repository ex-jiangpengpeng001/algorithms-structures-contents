package com.mashibing.juc.c_001_00_Volatile;

import com.mashibing.util.SleepHelper;

public class T01_HelloVolatile {
    private static volatile boolean running = true;

    private static void m() {
        System.out.println("m start");
        while (running) {
            //System.out.println("hello");
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {

        new Thread(T01_HelloVolatile::m, "t1").start();

        SleepHelper.sleepSeconds(1);

        running = false;
    }
}
