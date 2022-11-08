package com.mashibing.sync;

import org.openjdk.jol.info.ClassLayout;

public class T04_HelloJOL {

    public static void main(String[] args) throws Exception {

        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }

    }

}
