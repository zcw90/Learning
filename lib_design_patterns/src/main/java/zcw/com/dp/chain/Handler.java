package zcw.com.dp.chain;

/**
 * Created by 朱城委 on 2019/8/23.<br><br>
 */
public abstract class Handler {
    private Handler successor;

    public abstract void handle(int money);

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}
