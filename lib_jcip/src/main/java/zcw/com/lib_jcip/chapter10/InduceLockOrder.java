package zcw.com.lib_jcip.chapter10;

/**
 * Created by 朱城委 on 2019/11/27.<br><br>
 */
public class InduceLockOrder {
    private static final Object tieLock = new Object();

    public void transferMoney(final Account fromAccount, final Account toAccount, final DollarAmount amount) throws InsufficientFundsException {
        class Helper {
            public void transfer() throws InsufficientFundsException {
                if(fromAccount.getBalance().compareTo(amount) < 0) {
                    throw new InsufficientFundsException();
                }
                else {
                    fromAccount.debit(amount);
                    toAccount.credit(amount);
                }
            }
        }

        int fromHash = System.identityHashCode(fromAccount);
        int toHash = System.identityHashCode(toAccount);
        if(fromHash < toHash) {
            synchronized (fromAccount) {
                synchronized (toAccount) {
                    new Helper().transfer();
                }
            }
        }
        else if(fromHash > toHash) {
            synchronized (toAccount) {
                synchronized (fromAccount) {
                    new Helper().transfer();
                }
            }
        }
        else {
            synchronized (tieLock) {
                synchronized (fromAccount) {
                    synchronized (toAccount) {
                        new Helper().transfer();
                    }
                }
            }
        }
    }

    interface DollarAmount extends Comparable<DollarAmount> {

    }

    interface Account {
        void debit(DollarAmount amount);

        void credit(DollarAmount amount);

        DollarAmount getBalance();

        int getAccNo();
    }

    class InsufficientFundsException extends Exception {

    }
}
