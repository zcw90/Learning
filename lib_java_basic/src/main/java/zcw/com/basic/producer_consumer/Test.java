package zcw.com.basic.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by 朱城委 on 2019/11/8.<br><br>
 */
public class Test {

    private static Random random = new Random(10);

    private static final int MAX_ITEM = 10;
    private static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();

        new Thread(new Producer()).start();
//        new Thread(new Producer()).start();
//        new Thread(new Producer()).start();
    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            synchronized (queue) {
                while (true) {
                    try {
                        while (queue.size() >= MAX_ITEM) {
                            System.out.println(Thread.currentThread().getName() + " Producer wait.");
                            queue.wait();
                        }

                        if(queue.size() != 0 && queue.size() > random.nextInt(10)) {
                            System.out.println(Thread.currentThread().getName() + " Producer wait. queue size: (" + queue.size() + ") " + queue);
                            queue.wait();
                        }

                        queue.offer("Item");
                        System.out.println(Thread.currentThread().getName() + " offer item, queue size: " + queue.size());
                        Thread.sleep(500);

                        queue.notifyAll();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            synchronized (queue) {
                while (true) {
                    try {
                        while (queue.size() <= 0) {
                            System.out.println(Thread.currentThread().getName() + " Consumer wait.");
                            queue.wait();
                        }

                        if(queue.size() != 10 && queue.size() < 1 + random.nextInt(9)) {
                            System.out.println(Thread.currentThread().getName() + " Consumer wait. queue size: (" + queue.size() + ") " + queue);
                            queue.wait();
                        }

                        queue.poll();
                        System.out.println(Thread.currentThread().getName() + " poll item, queue size: " + queue.size());
                        Thread.sleep(500);

                        queue.notifyAll();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
