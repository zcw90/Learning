package zcw.com.dp.visitor;

/**
 * Created by 朱城委 on 2019/10/28.<br><br>
 */
public class CFO implements Viewer {

    @Override
    public void viewAbstractBill(AbstractBill bill) {
        System.out.println("财务主管查看账本时，每一个都核对项目和金额，金额是" + bill.getAmount() + "，项目是" + bill.getItem());
    }
}
