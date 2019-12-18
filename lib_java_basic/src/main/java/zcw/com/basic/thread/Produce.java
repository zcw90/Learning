package zcw.com.basic.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by 朱城委 on 2019/5/9.<br><br>
 * 生产者，消费者
 */
public class Produce {
    public static void main(String[] args) {
        int maxSize = 10;
        LinkedList<String> list = new LinkedList<>();
        Thread threadProducer = new Thread(new Producer(list, maxSize), "Producer1");
        Thread threadProducer2 = new Thread(new Producer(list, maxSize), "Producer2");
        Thread threadConsumer = new Thread(new Consumer(list), "Consumer1");
        threadProducer2.start();
        threadProducer.start();
        threadConsumer.start();
    }
}

class Producer implements Runnable {
    private static int count = 1;

    private Queue<String> queue;
    private int maxSize = 10;

    public Producer(Queue<String> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        String goods;
        while (true) {
            synchronized (queue) {
                try {
                    while (queue.size() >= maxSize) {
                        System.out.println(Thread.currentThread().getName() + " Produce wait.");
                        queue.wait();
                    }

                    Thread.sleep(new Random().nextInt(100) + 100);
                    goods = "Goods(" + count++ + (")");
                    System.out.println(Thread.currentThread().getName() + " Produce a goods: " + goods);
                    queue.offer(goods);
                    queue.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Consumer implements Runnable {
    private Queue<String> queue;

    public Consumer(Queue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                try {
                    while (queue.size() <= 0) {
                        System.out.println(Thread.currentThread().getName() + " Consumer wait.");
                        queue.wait();
                    }

                    Thread.sleep(new Random().nextInt(100) + 100);
                    System.out.println(Thread.currentThread().getName() + " Consume a goods: " + queue.poll() + "----");
                    queue.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
