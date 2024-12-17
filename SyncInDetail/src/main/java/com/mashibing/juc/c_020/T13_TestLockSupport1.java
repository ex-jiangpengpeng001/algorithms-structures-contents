package com.mashibing.juc.c_020;

import java.util.concurrent.locks.LockSupport;

public class T13_TestLockSupport1 {
    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread();

        new Thread(() -> {
            try {
                System.out.println("线程：" + Thread.currentThread().getName() + " 开始...");
                Thread.sleep(3000L);
                System.out.println("线程：" + Thread.currentThread().getName() + " 睡眠结束。");
                mainThread.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        LockSupport.park();

        System.out.println("main....");

        // 3s后，正常输出main....
        // 说明park()方法可正常响应中断

    }
}
