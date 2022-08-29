package com.mashibing.juc.c_000_threadbasic;

import com.mashibing.util.SleepHelper;

/**
 * interrupt与sleep() wait() join()
 */
public class T09_Interrupt_and_sync {

    private static Object o = new Object();

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            synchronized (o) {
                SleepHelper.sleepSeconds(10);
            }
        });

        t.start();

        SleepHelper.sleepSeconds(1);

        Thread t2 = new Thread(()->{
            synchronized (o) {

            }
            System.out.println("t2 end!");
        });

        t2.start();

        SleepHelper.sleepSeconds(1);

        t2.interrupt();
    }
}
