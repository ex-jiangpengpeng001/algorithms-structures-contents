package com.mashibing.sync;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

public class T07_HelloJOL {
    public static void main(String[] args) throws Exception {
        Object o = new Object();
        Thread thread = new Thread(() -> {
            synchronized(o) {
                System.out.println("--THREAD START--:" + ClassLayout.parseInstance(o).toPrintable()); // 偏向锁
                try {
                    o.wait(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("--THREAD END--:" + ClassLayout.parseInstance(o).toPrintable()); // 重量级锁
            }
        });
        thread.start();
        thread.join();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("--END--:" + ClassLayout.parseInstance(o).toPrintable()); // 无锁
    }
}
