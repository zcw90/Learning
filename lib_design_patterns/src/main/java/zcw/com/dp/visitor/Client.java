package zcw.com.dp.visitor;

/**
 * Created by 朱城委 on 2019/10/28.<br><br>
 */
public class Client {
    public static void main(String[] args) {
        AccountBook accountBook = new AccountBook();

        // 增加2条收入
        accountBook.addBill(new IncomeBill(10000, "卖商品"));
        accountBook.addBill(new IncomeBill(12000, "卖广告位"));

        // 增加2条支出
        accountBook.addBill(new ConsumeBill(1000, "工资"));
        accountBook.addBill(new ConsumeBill(2000, "材料费"));

        Viewer boss = new Boss();
        Viewer cpa = new CPA();
        Viewer cfo = new CFO();

        accountBook.show(boss);
        accountBook.show(cpa);
        accountBook.show(cfo);

        ((Boss)boss).getTotalIncome();
        ((Boss)boss).getTotalConsume();
    }
}
