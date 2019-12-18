package zcw.com.basic.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 朱城委 on 2019/9/24.<br><br>
 */
public class Cooperation {
    private static final Random RANDOM = new Random();
    private static final int BUFFER_SIZE = 10;
    private static AtomicInteger count0 = new AtomicInteger(0);

    private static List<String> buffer = new ArrayList<>();

    static class Consumer implements Runnable {
        private int count;
        private int constant = RANDOM.nextInt(10);

        @Override
        public void run() {
            synchronized (buffer) {
                while (true) {
                    while (buffer.isEmpty()) {
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    if(count > constant) {
                        constant = RANDOM.nextInt(10);
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        Thread.sleep(RANDOM.nextInt(3000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " consumer " + buffer.remove(0));
                    buffer.notifyAll();
                    count++;
                }
            }
        }
    }

    static class Producer implements Runnable {
        private int count;
        private int constant = RANDOM.nextInt(10);

        @Override
        public void run() {
            synchronized (buffer) {
                while (true) {
                    while (buffer.size() >= BUFFER_SIZE) {
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    if(count > constant) {
                        constant = RANDOM.nextInt(10);
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        Thread.sleep(RANDOM.nextInt(3000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String goods = "Goods" + count0.getAndIncrement();
                    buffer.add(goods);
                    System.out.println(Thread.currentThread().getName() + " produce " +  goods);
                    buffer.notifyAll();
                    count++;
                }
            }
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < 2; i++) {
            new Thread(new Consumer(), "Consumer" + (i + 1)).start();
            new Thread(new Producer(), "Producer" + (i + 1)).start();
        }
    }
}
