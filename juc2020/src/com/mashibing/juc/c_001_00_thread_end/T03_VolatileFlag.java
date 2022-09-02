package com.mashibing.juc.c_001_00_thread_end;

import com.mashibing.util.SleepHelper;

public class T03_VolatileFlag {

    private static volatile boolean running = true;

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            long i = 0L;
            while (running) {
                //wait recv accept
                i++;
            }
            System.out.println("end and i = " + i); //4180300145 4207671355
        });

        t.start();

        SleepHelper.sleepSeconds(1);

        running = false;
    }
}
