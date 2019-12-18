package zcw.com.lib_jcip.chapter8;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/**
 * Created by 朱城委 on 2019/11/26.<br><br>
 */
public class BoundedExecutor {
    private final Executor executor;
    private final Semaphore semaphore;

    public BoundedExecutor(Executor executor, int bound) {
        this.executor = executor;
        semaphore = new Semaphore(bound);
    }

    public void submitTask(final Runnable runnable) throws InterruptedException {
        semaphore.acquire();
        try {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        runnable.run();
                    }
                    finally {
                        semaphore.release();
                    }
                }
            });
        }
        catch (RejectedExecutionException e) {
            e.printStackTrace();
            semaphore.release();
        }
    }
}
