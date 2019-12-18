package zcw.com.dp.visitor;

/**
 * Created by 朱城委 on 2019/10/28.<br><br>
 */
public interface AccountBookViewer {

    void view(ConsumeBill consumeBill);

    void view(IncomeBill incomeBill);
}
