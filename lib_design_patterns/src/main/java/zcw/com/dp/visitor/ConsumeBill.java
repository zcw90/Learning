package zcw.com.dp.visitor;

/**
 * Created by 朱城委 on 2019/10/28.<br><br>
 */
public class ConsumeBill extends AbstractBill {

    public ConsumeBill(double amount, String item) {
        super(amount, item);
    }

    @Override
    public void accept(Viewer viewer) {
        if(viewer instanceof AbstractViewer) {
            ((AbstractViewer)viewer).viewConsumeBill(this);
            return ;
        }

        viewer.viewAbstractBill(this);
    }
}
