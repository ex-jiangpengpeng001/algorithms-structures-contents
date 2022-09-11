package com.mashibing.sync;

import org.openjdk.jol.info.ClassLayout;

/**
 * 假如锁处于偏向状态，这时来了竞争者，那么他的状态是什么？
 */
public class T04_HelloJOL {
    public static void main(String[] args) throws Exception {

        //Thread.sleep(5000);

        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }

}
