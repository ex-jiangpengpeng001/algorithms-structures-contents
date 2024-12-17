package com.mashibing.class01;

public class Code02_SumOfFactorial {

    public static long f1(int N) {
        long ans = 0;
        for (int i = 1; i <= N; i++) {
            ans += factorial(i);
        }
        return ans;
    }

    private static long factorial(int N) {
        long ans = 1;
        for (int i = 1; i <= N; i++) {
            ans *= i;
        }
        return ans;
    }

    public static long f2(int N) {
        long ans = 0;
        long cur = 1;
        for (int i = 1; i <= N; i++) {
            cur = cur * i;
            ans += cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        int N = 1000;
        long start = System.currentTimeMillis();
        System.out.print(f1(N));
        long scend = System.currentTimeMillis();
        System.out.println(" " + (scend - start));
        System.out.print(f2(N));
        long end = System.currentTimeMillis();
        System.out.println(" " + (end - scend));
    }

}
