package com.mashibing.dp.singleton;

public class Mgr06 {
    private static volatile Mgr06 INSTANCE;

    private Mgr06() {};

    public static Mgr06 getInstance() {
        // 业务逻辑代码省略
        if (INSTANCE == null) { // Double Check Lock
            // 双重检查
            synchronized(Mgr06.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr06();
                }
            }
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->
                    System.out.println(Mgr06.getInstance().hashCode())
            ).start();
        }
    }
}