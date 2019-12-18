package zcw.com.basic.thread;

/**
 * Created by 朱城委 on 2019/5/23.<br><br>
 */
public class ThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(11);

        // 新建一个线程Thread-1，对threadLocal变量进行操作
        new Thread("Thread-1") {
            @Override
            public void run() {
                threadLocal.set(22);
                System.out.println("Thread Name: " + Thread.currentThread().getName() + " threadLocal = " + threadLocal.get());
            }
        }.start();

        // 新建一个线程Thread-2，对threadLocal变量进行操作
        new Thread("Thread-2") {
            @Override
            public void run() {
                threadLocal.set(33);
                System.out.println("Thread Name: " + Thread.currentThread().getName() + " threadLocal = " + threadLocal.get());
            }
        }.start();

        Thread.sleep(100);  // 阻塞100ms,让线程Thread-1、Thread-2先输出
        System.out.println("Thread Name: " + Thread.currentThread().getName() + " threadLocal = " + threadLocal.get());

        ThreadLocal<Person> threadLocal1 = new ThreadLocal<>();
        threadLocal1.set(new Person());
        System.out.println("Thread Name: " + Thread.currentThread().getName() + " threadLocal1 = " + threadLocal1.get());

        new Thread("Thread-3") {
            @Override
            public void run() {
                threadLocal1.set(new Person());
                System.out.println("Thread Name: " + Thread.currentThread().getName() + " threadLocal = " + threadLocal1.get());
            }
        }.start();
    }
}

class Person {
}
