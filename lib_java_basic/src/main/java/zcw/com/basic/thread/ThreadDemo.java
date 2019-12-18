package zcw.com.basic.thread;

/**
 * Created by 朱城委 on 2019/5/9.<br><br>
 */
public class ThreadDemo {

    private volatile static boolean print = true;

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();

        Thread threadA = new Thread(new RunA(threadDemo));
        Thread threadB = new Thread(new RunB(threadDemo));

        threadA.start();
        threadB.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        print = false;
    }

    static class RunA implements Runnable {
        private Object object;

        public RunA(Object object) {
            this.object = object;
        }

        @Override
        public void run() {
            synchronized (object) {
                while (print) {
                    System.out.print("A");
                    try {
                        Thread.sleep(200);
                        object.wait();
                        object.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class RunB implements Runnable {
        private Object object;

        public RunB(Object object) {
            this.object = object;
        }

        @Override
        public void run() {
            synchronized (object) {
                while (print) {
                    System.out.print("B\t");
                    try {
                        object.notifyAll();
                        Thread.sleep(200);
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
