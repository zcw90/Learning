package zcw.com.dp.visitor;

/**
 * Created by 朱城委 on 2019/10/28.<br><br>
 */
public abstract class AbstractViewer implements Viewer {

    abstract void viewConsumeBill(ConsumeBill bill);

    abstract void viewIncomeBill(IncomeBill bill);

    @Override
    public final void viewAbstractBill(AbstractBill bill) {

    }
}
