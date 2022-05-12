import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Bank {

    private Map<String, Account> accounts = new TreeMap<>();
    private final Random random = new Random();

    public Bank() {
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    private void doTransfer(Account fromAccount, Account toAccount, long amount) throws InterruptedException {
        if (fromAccount.getMoney() >= amount) {
            fromAccount.setMoney(fromAccount.getMoney() - amount);
            toAccount.setMoney(toAccount.getMoney() + amount);
        }
        if (amount >= 50_000) {
            if (isFraud(fromAccount.getAccNumber(), toAccount.getAccNumber(), amount)) {
                fromAccount.block();
                toAccount.block();
            }
        }
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);
        if (!(fromAccount.getBlocked() || toAccount.getBlocked())) {
            Account firstSyncAcc = (Integer.parseInt(fromAccountNum) > Integer.parseInt(toAccountNum) ? fromAccount : toAccount);
            Account secondSyncAcc = (firstSyncAcc.equals(fromAccount) ? toAccount : fromAccount);
            synchronized (firstSyncAcc) {
                synchronized (secondSyncAcc) {
                    doTransfer(fromAccount, toAccount, amount);
                }
            }
        }
    }

    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        long sum = 0L;
        for (Account account : accounts.values()) {
            sum += account.getMoney();
        }
        return sum;
    }

    public void addAccount(Account acc) {
        accounts.put(acc.getAccNumber(), acc);
    }
}
