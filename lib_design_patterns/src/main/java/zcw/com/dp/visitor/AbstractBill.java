package zcw.com.dp.visitor;

/**
 * Created by 朱城委 on 2019/10/28.<br><br>
 */
public abstract class AbstractBill implements Bill {

    protected double amount;

    protected String item;

    public AbstractBill(double amount, String item) {
        super();
        this.amount = amount;
        this.item = item;
    }

    public double getAmount() {
        return amount;
    }

    public String getItem() {
        return item;
    }
}
