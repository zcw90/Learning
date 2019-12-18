package zcw.com.basic.thread;

/**
 * Created by 朱城委 on 2019/5/21.<br><br>
 */
public class Test {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("Main Thread");

        for(int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    threadLocal.set("Thread " + finalI);
                    System.out.println("Thread name: " + Thread.currentThread().getName() + "    threadLocal:" + threadLocal.get() + "\tthreadLocal address: " + threadLocal);
                }
            }).start();
        }

        System.out.println("Thread name: " + Thread.currentThread().getName() + "    threadLocal:" + threadLocal.get());
    }
}
