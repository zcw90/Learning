package zcw.com.dp.chain;

/**
 * Created by 朱城委 on 2019/8/23.<br><br>
 */
public class ProjectManagerHandler extends Handler {

    @Override
    public void handle(int money) {
        if(money < 0) {
            System.out.println(toString() + "金额不能为负数");
        }

        if(money < 5000) {
            System.out.println(toString() + "项目经理批准了" + money + "元经费");
            return ;
        }

        if(getSuccessor() != null) {
            getSuccessor().handle(money);
        }
        else {
            System.out.println(toString() + "项目经理不知道应该如何处理了");
        }
    }

    @Override
    public String toString() {
        return "我能批准5000以下的经费：";
    }
}
