package zcw.com.basic;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        String string = null;
//        try {
//            string = new String("ABC");
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        String string2 = "ABC";
//        System.out.println(string);
//        System.out.println(string2);
//
//        System.out.println("string == string2: " + string == string2);
        int value = 10000;
        System.out.println(value);
        System.out.println(tableSizeFor(value));

        value = 1000;
        System.out.println(value);
        System.out.println(tableSizeFor(value));

        value = 100;
        System.out.println(value);
        System.out.println(tableSizeFor(value));

        HashMap<String, String> map = new HashMap<>(100);
        for(int i = 0; i < 10; i++) {
            map.put("AAA" + i, "value - " + i);
        }
        System.out.println();

        int[] array = {-3, 0, 3, 7, 14, 28, 32, 33, 59, 123, 247, 509, 1021, 2034, 3899, 8047};
        for(int v : array) {
            System.out.print(v + ":" + tableSizeFor(v) + "\t");
        }
        System.out.println();

        map = new HashMap<>(10000);
        for(int i = 0; i < 10000; i++) {
            map.put("AAA" + i, "value - " + i);
        }

        System.out.println("Map size: " + map.size());
    }

    public static void test1() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Thread name:" + Thread.currentThread().getName());
                return 10;
            }
        };

        Future<Integer> future = service.submit(callable);
        System.out.println(future.get());
        service.shutdownNow();
    }

    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    static final int getIndex(int n, Object obj) {
        return (n - 1) & hash(obj);
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
