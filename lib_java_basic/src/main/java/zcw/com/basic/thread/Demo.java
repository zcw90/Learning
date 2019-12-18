package zcw.com.basic.thread;

/**
 * Created by 朱城委 on 2019/11/15.<br><br>
 */
public class Demo {

    private static volatile int a = 0;
    static volatile int b = 0;

    public static void main(String[] args) {
        Demo demo = new Demo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.b++;
                a++;
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " a:" + a);
                System.out.println(Thread.currentThread().getName() + " b:" + b);
            }
        }).start();
    }
}
