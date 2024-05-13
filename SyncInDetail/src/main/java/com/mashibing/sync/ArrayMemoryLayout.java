package com.mashibing.sync;

import org.openjdk.jol.info.ClassLayout;

public class ArrayMemoryLayout {

    static class People {

        private Long id;

        private String name;
    }

    public static void main(String[] args) {
        People[] peoples = {new People()};
        System.out.println(ClassLayout.parseInstance(peoples).toPrintable());
    }
}
