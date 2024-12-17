package com.mashibing.sync;

import org.openjdk.jol.info.ClassLayout;
import java.util.concurrent.TimeUnit;

class User {}

public class T10_HelloJOL {
    public static void main(String[] args) throws InterruptedException {
        User user = new User();
        System.out.println("--MAIN--:" + ClassLayout.parseInstance(user).toPrintable());
        Thread thread1 = new Thread(() -> {
            synchronized (user) {
                System.out.println("--THREAD1--:" + ClassLayout.parseInstance(user).toPrintable());
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (user) {
                System.out.println("--THREAD2--:" + ClassLayout.parseInstance(user).toPrintable());
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        TimeUnit.SECONDS.sleep(3);
        System.out.println(ClassLayout.parseInstance(user).toPrintable());
    }
}
