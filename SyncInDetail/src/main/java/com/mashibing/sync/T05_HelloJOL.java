package com.mashibing.sync;

import org.openjdk.jol.info.ClassLayout;

public class T05_HelloJOL {

    public static void main(String[] args) throws Exception {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable()); // 匿名偏向
        System.out.println(Integer.toHexString(o.hashCode()));
        System.out.println(ClassLayout.parseInstance(o).toPrintable()); // 无锁
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable()); // 轻量级锁
        }
    }
}
