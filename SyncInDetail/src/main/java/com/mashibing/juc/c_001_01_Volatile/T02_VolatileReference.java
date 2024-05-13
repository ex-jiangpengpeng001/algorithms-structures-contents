package com.mashibing.juc.c_001_01_Volatile;

import com.mashibing.util.SleepHelper;

public class T02_VolatileReference {

    private static class A {
        boolean running = true;

        void m() {
            System.out.println("m start");
            while (running) {
            }
            System.out.println("m end!");
        }
    }

    private static volatile A a = new A();

    public static void main(String[] args) {
        new Thread(a::m, "t1").start();
        SleepHelper.sleepSeconds(1);
        a.running = false;
    }
}
