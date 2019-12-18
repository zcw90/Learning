package zcw.com.basic;

/**
 * Created by 朱城委 on 2019/11/8.<br><br>
 */
public class Util {

    public static void wait(Object object) {
        wait(object, 0);
    }

    /**
     * see {@link Object#wait(long)}
     * @param object
     * @param timeout
     */
    public static void wait(Object object, long timeout) {
        try {
            object.wait(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
