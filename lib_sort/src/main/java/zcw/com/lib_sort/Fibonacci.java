package zcw.com.lib_sort;

/**
 * Created by 朱城委 on 2019/1/11.<br><br>
 */
public class Fibonacci {

    public static void main(String[] args) {
        long start = System.nanoTime();
        fibonacci(5);
        System.out.println("time: " + (System.nanoTime() - start));

        start = System.currentTimeMillis();
        for(int i = 0; i <= 50; i++) {

            System.out.println(i +  ":" + fibonacci2(i));
        }
        System.out.println("fibonacci2 time: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for(int i = 0; i <= 50; i++) {
            System.out.println(i +  ":" + fibonacci3(i));
        }
        System.out.println("fibonacci3 time: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for(int i = 0; i <= 50; i++) {
            System.out.println(i +  ":" + fibonacci4(i));
        }
        System.out.println("fibonacci4 time: " + (System.currentTimeMillis() - start));
    }

    private static long fibonacci(long n) {
        if(n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static long fibonacci2(long n) {
        if(n <= 1) {
            return n;
        }

        int size = (int)n + 1;
        long[] result = new long[size];
        result[0] = 0;
        result[1] = 1;
        for(int i = 2; i <= n; i++) {
            result[i] = result[i - 2] + result[i - 1];
        }
        return result[size - 1];
    }

    private static long fibonacci3(long n) {
        if(n <= 1) {
            return n;
        }

        long result = 0;
        long result_2 = 0;
        long result_1 = 1;
        for(int i = 2; i <= n; i++) {
            result = result_2 + result_1;
            result_2 = result_1;
            result_1 = result;
        }
        return result;
    }

    private static long fibonacci4(long n) {
        if(n <= 1) {
            return n;
        }

        return fibonacci4Process(n, 0, 1, 2);
    }

    private static long fibonacci4Process(long n, long prePreVal, long preVal, long begin) {
        if(n == begin) {
            return prePreVal + preVal;
        }
        else {
            begin++;
            return fibonacci4Process(n, preVal, prePreVal + preVal, begin);
        }
    }
}
