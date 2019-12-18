package zcw.com.lib_jcip.chapter10;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 朱城委 on 2019/11/27.<br><br>
 */
public class DynamicOrderDeadlock {

    public static void transferMoney(Account fromAccount, Account toAccount, DollarAmount amount) throws InsufficientFundsException {
        synchronized (fromAccount) {
            synchronized (toAccount) {
                if(fromAccount.getBalance().compareTo(amount) < 0) {
                    throw new InsufficientFundsException();
                }
                else {
                    fromAccount.debit(amount);
                    toAccount.credit(amount);
                }
            }
        }
    }

    static class DollarAmount implements Comparable<DollarAmount> {

        public DollarAmount(int amount) {

        }

        public DollarAmount add(DollarAmount amount) {
            return null;
        }

        public DollarAmount subtract(DollarAmount amount) {
            return null;
        }

        @Override
        public int compareTo(DollarAmount o) {
            return 0;
        }
    }

    static class Account {
        private DollarAmount balance;
        private final int acctNo;
        private static final AtomicInteger sequence = new AtomicInteger();

        public Account() {
            acctNo = sequence.incrementAndGet();
        }

        void debit(DollarAmount amount) {
            balance = balance.subtract(amount);
        }

        void credit(DollarAmount amount) {
            balance = balance.add(amount);
        }

        DollarAmount getBalance() {
            return balance;
        }

        int getAcctNo() {
            return acctNo;
        }
    }

    static class InsufficientFundsException extends Exception {

    }
}
