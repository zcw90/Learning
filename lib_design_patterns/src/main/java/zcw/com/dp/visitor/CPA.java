package zcw.com.dp.visitor;

/**
 * Created by 朱城委 on 2019/10/28.<br><br>
 */
public class CPA extends AbstractViewer {

    @Override
    void viewConsumeBill(ConsumeBill bill) {
        if(bill.getItem().equals("工资")) {
            System.out.println("注会查看工资是否交个人所得税。");
        }
    }

    @Override
    void viewIncomeBill(IncomeBill bill) {
        System.out.println("注会查看收入交税了没。");
    }
}
