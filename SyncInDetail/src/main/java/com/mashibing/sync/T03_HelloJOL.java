package com.mashibing.sync;

import org.openjdk.jol.info.ClassLayout;
public class T03_HelloJOL {
    public static void main(String[] args) throws Exception {
        Object o = new Object();
        Thread.sleep(5000);
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
