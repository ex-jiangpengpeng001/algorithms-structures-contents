package com.mashibing.juc.c_000_threadbasic;

import com.mashibing.util.SleepHelper;

public class T08_Interrupt_and_wait {
    private static Object o = new Object();

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            synchronized (o) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    System.out.println("Thread is interrupted!");
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });

        t.start();

        SleepHelper.sleepSeconds(5);

        t.interrupt();
    }
}
