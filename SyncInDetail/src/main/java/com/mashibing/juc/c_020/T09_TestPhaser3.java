package com.mashibing.juc.c_020;

import java.util.concurrent.Phaser;

public class T09_TestPhaser3 {
    public static void main(String[] args) {
        // 创建一个Phaser对象，初始时没有任何参与者
        Phaser phaser = new Phaser();

        // 创建一个任务，使用Phaser来同步两个阶段的执行
        Runnable task = () -> {
            try {
                // 注册当前线程为Phaser的参与者
                phaser.register();

                // 执行第一阶段的任务
                System.out.println(Thread.currentThread().getName() + " 到达第一阶段");

                // 等待其他线程到达第一阶段
                phaser.arriveAndAwaitAdvance();

                // 执行第二阶段的任务
                System.out.println(Thread.currentThread().getName() + " 到达第二阶段");

                // 等待其他线程到达第二阶段，并准备结束
                phaser.arriveAndAwaitAdvance();

                // 所有线程都完成了任务
                System.out.println(Thread.currentThread().getName() + " 任务完成");

            } catch (Exception e) {
                Thread.currentThread().interrupt();
            } finally {
                // 无论任务是否成功完成，都注销当前线程
                phaser.arriveAndDeregister();
            }
        };

        // 创建并启动两个线程来执行任务
        Thread thread1 = new Thread(task, "线程1");
        Thread thread2 = new Thread(task, "线程2");

        thread1.start();
        thread2.start();
    }
}


