package com.mashibing.sync;

import org.openjdk.jol.info.ClassLayout;

public class ObjectMemoryLayout {

    static class People {

        private long id;

        private String name;
    }

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(new People()).toPrintable());
    }

}
