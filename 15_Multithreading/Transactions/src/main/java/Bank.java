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

    public synchronized void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);
        if (!(fromAccount.getBlocked() || toAccount.getBlocked())) {
            long fromAccountBalance = fromAccount.getMoney();

            if (fromAccountBalance >= amount) {
                fromAccount.setMoney(fromAccountBalance - amount);
                toAccount.setMoney(toAccount.getMoney() + amount);
            }

            if (amount >= 50_000) {
                if (isFraud(fromAccountNum, toAccountNum, amount)) {
                    fromAccount.block();
                    toAccount.block();
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
