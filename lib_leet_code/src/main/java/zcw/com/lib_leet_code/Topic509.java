package zcw.com.lib_leet_code;

/**
 * Created by 朱城委 on 2019/4/29.<br><br>
 */
public class Topic509 {
    public static void main(String[] args) {
//        System.out.println("fib(40): " + fib(40));
//        System.out.println("fib2(3): " + fib2(3));
        System.out.println("fib3(100): " + fib3(12));
    }

    public static int fib(int N) {
        if(N < 0) {
            throw new IllegalArgumentException("N can't be less than 0.");
        }

        if(N == 0) {
            return 0;
        }

        if(N == 1) {
            return 1;
        }

        return fib(N - 1) + fib(N - 2);
    }

    public static int fib2(int N) {
        if(N < 0) {
            throw new IllegalArgumentException("N can't be less than 0.");
        }

        if(N == 0) {
            return 0;
        }

        if(N == 1) {
            return 1;
        }

        int[] result = new int[N + 1];
        result[0] = 0;
        result[1] = 1;
        for(int i = 2; i <= N; i++) {
            result[i] = result[i - 2] + result[i - 1];
        }
        return result[N];
    }

    public static int fib3(int N) {
        if(N < 0) {
            throw new IllegalArgumentException("N can't be less than 0.");
        }

        if(N == 0) {
            return 0;
        }

        if(N == 1) {
            return 1;
        }

        int value0 = 0;
        int value1 = 1;
        int result = 0;
        for(int i = 2; i <= N; i++) {
            result  = value0 + value1;
            value0 = value1;
            value1 = result;
        }

        return result;
    }
}
