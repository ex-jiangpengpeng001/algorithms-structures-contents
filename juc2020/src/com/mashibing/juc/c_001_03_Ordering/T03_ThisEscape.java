package com.mashibing.juc.c_001_03_Ordering;

public class T03_ThisEscape {
    private int num = 8;

    Thread t;

    public T03_ThisEscape() {
        t = new Thread(() -> System.out.println(num));
    }

    public void start() {
        t.start();
    }

    public static void main(String[] args) throws Exception {
        new T03_ThisEscape();
        System.in.read();
    }
}
