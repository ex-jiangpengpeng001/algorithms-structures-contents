package com.mashibing.sync;

import org.openjdk.jol.info.ClassLayout;

public class T06_HelloJOL {
    public static void main(String[] args) throws Exception {
        Object o = new Object();
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable()); // 偏向锁
        }
        Thread thread = new Thread(() -> {
            synchronized(o) {
                System.out.println("--THREAD--:"+ClassLayout.parseInstance(o).toPrintable()); // 轻量级锁
            }
        });
        thread.start();
        thread.join();
        System.out.println("--END--:"+ClassLayout.parseInstance(o).toPrintable()); // 无锁不可偏向状态
    }
}
