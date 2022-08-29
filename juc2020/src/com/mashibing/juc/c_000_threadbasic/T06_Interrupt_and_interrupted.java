package com.mashibing.juc.c_000_threadbasic;

import com.mashibing.util.SleepHelper;

/**
 * interrupt与interrupted()
 */
public class T06_Interrupt_and_interrupted {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (;;) {
                if (Thread.interrupted()) {
                    System.out.println("Thread is interrupted!");
                    System.out.println(Thread.interrupted());
                }
            }
        });

        t.start();

        SleepHelper.sleepSeconds(2);

        t.interrupt();

        //思考一下，如果在这里写
        //t.interrupted();
        //输出的是哪个线程的中断状态
    }
}
