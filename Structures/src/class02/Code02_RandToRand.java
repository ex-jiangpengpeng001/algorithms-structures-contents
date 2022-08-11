package class02;

public class Code02_RandToRand {
    public static void main(String[] args) {
        System.out.println("测试开始");
        // Math.random() -> double -> [0,1)
        //

        int testTimes = 10000000;
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() < 0.75) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);

        System.out.println("=========");

        // [0,1) -> [0,8)
        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() * 8 < 5) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println((double) 5 / (double) 8);


    }
}
