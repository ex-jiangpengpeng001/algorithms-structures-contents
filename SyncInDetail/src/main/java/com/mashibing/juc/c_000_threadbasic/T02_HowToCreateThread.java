package com.mashibing.juc.c_000_threadbasic;

import java.util.concurrent.*;

public class T02_HowToCreateThread {
    // 1、继承Thread，重写run()方法。
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello MyThread!");
        }
    }
    // 2、实现Runnable接口，重写run()方法。
    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello MyRun!");
        }
    }
    // 5、实现Callable接口，重写call()方法。
    static class MyCall implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("Hello MyCall");
            return "success";
        }
    }

    //启动线程的5种方式
    public static void main(String[] args) throws Exception {
        new MyThread().start(); // 1、new一个MyThread对象，并调用start()方法。
        new Thread(new MyRun()).start(); // 2、new一个Thread对象，传人MyRun对象，并调用start()方法
        new Thread(()->{
            System.out.println("Hello Lambda!");
        }).start(); // 3、使用lambda表达式创建对象，并调用start()方法。

        // 4、使用线程池。
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->{
            System.out.println("Hello ThreadPool");
        });
        // 5、利用线程池，异步调用MyCall对象中的call()方法，并返回值给Future对象。
        Future<String> f = service.submit(new MyCall());
        String s = f.get();
        System.out.println(s);
        service.shutdown();
        // 5、也可以使用FutureTask类，接收MyCall对象，FutureTask类已重写run()方法。
        FutureTask<String> task = new FutureTask<>(new MyCall()); // 5
        Thread t = new Thread(task);
        t.start();
        System.out.println(task.get());

    }
}
