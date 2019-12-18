package zcw.com.dp.visitor;

/**
 * Created by 朱城委 on 2019/10/28.<br><br>
 */
public class Boss extends AbstractViewer {

    private double totalIncome;

    private double totalConsume;


    @Override
    void viewConsumeBill(ConsumeBill bill) {
        totalConsume += bill.getAmount();
    }

    @Override
    void viewIncomeBill(IncomeBill bill) {
        totalIncome += bill.getAmount();
    }

    public double getTotalIncome() {
        System.out.println("老板查看账本，总收入是多少：" + totalIncome);
        return totalIncome;
    }

    public double getTotalConsume() {
        System.out.println("老板查看账本，总花费是多少：" + totalConsume);
        return totalConsume;
    }
}
