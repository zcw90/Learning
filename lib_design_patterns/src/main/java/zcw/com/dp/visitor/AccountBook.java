package zcw.com.dp.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 朱城委 on 2019/10/28.<br><br>
 */
public class AccountBook {

    private List<Bill> billList = new ArrayList<>();

    public void addBill(Bill bill) {
        billList.add(bill);
    }

    public void show(Viewer viewer) {
        for(Bill bill : billList) {
            bill.accept(viewer);
        }
    }
}
