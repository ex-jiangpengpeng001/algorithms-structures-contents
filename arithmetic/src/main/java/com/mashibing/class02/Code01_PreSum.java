package com.mashibing.class02;

public class Code01_PreSum {

    public static class RangeSum1 {

        private int[] arr;

        public RangeSum1(int[] array) {
            arr = array;
        }

        public int rangeSum(int L, int R) {
            int sum = 0;
            for (int i = L; i <= R; i++) {
                sum += arr[i];
            }
            return sum;
        }

    }

    public static class RangeSum2 {

        private int[] preSum;

        public RangeSum2(int[] array) {
            int N = array.length;
            preSum = new int[N];
            preSum[0] = array[0];
            for (int i = 1; i < N; i++) {
                preSum[i] = preSum[i - 1] + array[i];
            }
        }

        public int rangeSum(int L, int R) {
            return L == 0 ? preSum[R] : preSum[R] - preSum[L - 1];
        }

    }

    public static void main(String[] args) {
        int[] arr = {3, 2 , -1, 6, 7, 2, -2};
        RangeSum2 sum = new RangeSum2(arr);
        System.out.println(sum.rangeSum(3, 6));

    }

}
