package zcw.com.lib_jcip.chapter10;

/**
 * Created by 朱城委 on 2019/11/27.<br><br>
 */
public class LeftRightDeadlock {
    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRigth() {
        synchronized (left) {
            synchronized (right) {
                doSomething();
            }
        }
    }

    public void rigthLeft() {
        synchronized (right) {
            synchronized (left) {
                doSomethingElse();
            }
        }
    }

    void doSomething() {

    }

    void doSomethingElse() {

    }
}
