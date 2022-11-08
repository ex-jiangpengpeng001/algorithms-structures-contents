package com.mashibing.juc.c_000_threadbasic;

import java.util.concurrent.*;

public class T02_HowToCreateThread {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello MyThread!");
        }
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello MyRun!");
        }
    }

    static class MyCall implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("Hello MyCall");
            return "success";
        }
    }

    //启动线程的5种方式
    public static void main(String[] args) throws Exception {
        new MyThread().start(); // 1
        new Thread(new MyRun()).start(); // 2
        new Thread(()->{
            System.out.println("Hello Lambda!");
        }).start(); // 3

        FutureTask<String> task = new FutureTask<>(new MyCall()); // 5
        Thread t = new Thread(task);
        t.start();
        System.out.println(task.get());

        ExecutorService service = Executors.newCachedThreadPool(); // 4
        service.execute(()->{
            System.out.println("Hello ThreadPool");
        });
        Future<String> f = service.submit(new MyCall()); // 5
        String s = f.get();
        System.out.println(s);
        service.shutdown();

    }
}
