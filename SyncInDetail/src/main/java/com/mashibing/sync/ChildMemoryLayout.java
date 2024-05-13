package com.mashibing.sync;

import org.openjdk.jol.info.ClassLayout;

public class ChildMemoryLayout {

    static class People {

        private Long id;

        private String name;
    }

    static class Chinese extends People {

        private String nation;
    }


    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(new Chinese()).toPrintable());
    }
}
