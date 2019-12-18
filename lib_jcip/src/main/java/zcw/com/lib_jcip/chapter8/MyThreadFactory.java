package zcw.com.lib_jcip.chapter8;

import java.util.concurrent.ThreadFactory;

/**
 * Created by 朱城委 on 2019/11/26.<br><br>
 */
public class MyThreadFactory implements ThreadFactory {
    private final String poolName;

    public MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    @Override
    public Thread newThread(Runnable r) {
        return null;
    }
}
