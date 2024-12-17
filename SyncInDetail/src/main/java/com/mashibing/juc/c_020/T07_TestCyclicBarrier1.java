package com.mashibing.juc.c_020;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class T07_TestCyclicBarrier1 {
    public static void main(String[] args) {
        int parties = 4; // 参与线程数
        CyclicBarrier barrier = new CyclicBarrier(parties,
                () -> System.out.println("所有线程已到达屏障，开始汇总结果或进行下一轮准备..."));

        for (int i = 0; i < parties; i++) {
            new Thread(new Worker(barrier, "Worker-" + i)).start();
        }
    }

    static class Worker implements Runnable {
        private final CyclicBarrier barrier;
        private final String name;

        Worker(CyclicBarrier barrier, String name) {
            this.barrier = barrier;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    Thread.sleep((long) Math.round(100));
                    System.out.println(name + "第" + (i + 1) + " 次任务完成");
                    barrier.await(); // 等待所有线程完成当前轮次
                }
            } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
