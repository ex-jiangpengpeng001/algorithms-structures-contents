package com.mashibing.sync;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

public class T11_BulkRevoke {

    private static class A {}

    public static void main(String[] args) throws Exception {

        Thread.sleep(5000);
        List<A> listA = new ArrayList<>();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                A a = new A();
                synchronized (a) {
                    listA.add(a);
                }
            }
            try {
                Thread.sleep(100000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        Thread.sleep(3000);

        Thread t2 = new Thread(() -> {
            // 这里循环了40次。达到了批量撤销的阈值
            for (int i = 0; i < 40; i++) {
                A a = listA.get(i);
                synchronized (a) {
//                    System.out.println("t2 第" + i + "次 A.class的输出：");
//                    System.out.println(ClassLayout.parseInstance(A.class).toPrintable());
                }
            }
            try {
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();

        // ------------------分割线，前面代码不再赘述------------------
        Thread.sleep(3000);
        System.out.println("打印list中第11个对象的对象头：因为锁都已经释放，所以这里是无锁态 001");
        System.out.println(ClassLayout.parseInstance(listA.get(10)).toPrintable());
        System.out.println("打印list中第21个对象的对象头：触发批量重偏向，这里偏向线程t2");
        System.out.println(ClassLayout.parseInstance(listA.get(20)).toPrintable());
        System.out.println("打印list中第41个对象的对象头：这里没有被t2线程触达（因为只循环40），依然偏向t1");
        System.out.println(ClassLayout.parseInstance(listA.get(40)).toPrintable());

        Thread t3 = new Thread(() -> {
            for (int i = 20; i < 40 ; i++) {
                A a = listA.get(i);
                synchronized (a) {
                    if (i == 20 || i == 22) {
                        System.out.println("thread3 第" + i + "次 这里触发了批量锁撤销");
                        System.out.println(ClassLayout.parseInstance(a).toPrintable());
                    }
                }
            }
        });
        t3.start();

        Thread.sleep(10000);
        System.out.println("重新输出新实例A");
        System.out.println((ClassLayout.parseInstance(new A()).toPrintable()));
    }
}
