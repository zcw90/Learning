package zcw.com.dp.chain;

/**
 * Created by 朱城委 on 2019/8/23.<br><br>
 */
public class GroupHandler extends Handler {

    @Override
    public void handle(int money) {
        if(money < 0) {
            System.out.println(toString() + "金额不能为负数");
            return ;
        }

        if(money < 1000) {
            System.out.println(toString() + "组长批准了" + money + "元经费");
            return ;
        }

        if(getSuccessor() != null) {
            getSuccessor().handle(money);
        }
        else {
            System.out.println(toString() + "组长不知道应该如何处理了");
        }
    }

    @Override
    public String toString() {
        return "我能批准1000以下的经费：";
    }
}
