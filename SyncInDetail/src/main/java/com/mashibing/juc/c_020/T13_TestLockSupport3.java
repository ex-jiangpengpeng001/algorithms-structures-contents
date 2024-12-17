package com.mashibing.juc.c_020;

import java.util.concurrent.locks.LockSupport;

public class T13_TestLockSupport3 {
    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            // 让 Thread A 稍后运行
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 开始");
            LockSupport.park();
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + " 被唤醒！");
        }, "Thread A");

        Thread threadB = new Thread(() -> {
            LockSupport.unpark(threadA);
            LockSupport.unpark(threadA);
            System.out.println(Thread.currentThread().getName() + " 唤醒操作");
        }, "Thread B");

        threadA.start();
        threadB.start();
    }
}
