package zcw.com.basic.reader_writer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 朱城委 on 2019/11/8.<br><br>
 */
public class Test {

    private static int count = 0;

    private static int readCount = 0;

    private static final Lock writeLock = new ReentrantLock();
    private static final Lock readLock = new ReentrantLock();

    public static ExecutorService service = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        service.execute(new Reader());
        service.execute(new Writer());
    }

    static class Reader implements Runnable {

        @Override
        public void run() {
            while (true) {
                readLock.lock();
                readCount++;
                if(readCount == 1) {
                    writeLock.lock();
                }
                readLock.unlock();

                System.out.println(Thread.currentThread().getName() + " Reader read: " + count);
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                readLock.lock();
                readCount--;
                if(readCount == 0) {
                    writeLock.unlock();
                }
                readLock.unlock();
            }
        }
    }

    static class Writer implements Runnable {

        @Override
        public void run() {
            while (true) {
                writeLock.lock();

                System.out.println(Thread.currentThread().getName() + " Writer write count: " + ++count);
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                writeLock.unlock();
            }
        }
    }
}
