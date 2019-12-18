package zcw.com.lib_effective_java.chapter10;

import java.util.concurrent.TimeUnit;

/**
 * Created by 朱城委 on 2019/12/3.<br><br>
 */
public class StopThread {
    private static boolean stopRequested;

    public static void main(String[] arg) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            int i = 0;

            @Override
            public void run() {
                while (!stopRequested) {
                    i++;
                    System.out.println(i);
                }
            }
        });
        thread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
