package com.mashibing.juc.c_001_00_thread_end;

import com.mashibing.util.SleepHelper;

public class T04_Interrupte_and_NormalThread {

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            while (!Thread.interrupted()) {
                //sleep wait
            }
            System.out.println("t1 end!");
        });

        t.start();

        SleepHelper.sleepSeconds(1);

        t.interrupt();
    }
}
