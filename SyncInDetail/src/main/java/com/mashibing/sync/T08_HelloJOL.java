package com.mashibing.sync;

import org.openjdk.jol.info.ClassLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class T08_HelloJOL {
    private static Thread t1,t2;
    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            list.add(new Object());
        }

        t1 = new Thread(() -> {
            for (int i = 0; i < list.size(); i++) {
                synchronized (list.get(i)) {
                }
            }
            LockSupport.unpark(t2);
        });
        t2 = new Thread(() -> {
            LockSupport.park();
            for (int i = 0; i < 30; i++) {
                Object o = list.get(i);
                synchronized (o) {
                    if (i == 17 || i == 18 || i == 19) {
                        System.out.println("THREAD-2 Object"+(i+1)+":"+ClassLayout.parseInstance(o).toPrintable());
                    }
                }
            }
        });
        t1.start();
        t2.start();
        t2.join();

        TimeUnit.SECONDS.sleep(3);
        System.out.println("Object18:"+ClassLayout.parseInstance(list.get(17)).toPrintable());
        System.out.println("Object19:"+ClassLayout.parseInstance(list.get(18)).toPrintable());
        System.out.println("Object20:"+ClassLayout.parseInstance(list.get(19)).toPrintable());
        System.out.println("Object21:"+ClassLayout.parseInstance(list.get(20)).toPrintable());
        System.out.println("Object30:"+ClassLayout.parseInstance(list.get(29)).toPrintable());
        System.out.println("Object31:"+ClassLayout.parseInstance(list.get(30)).toPrintable());
    }
}
