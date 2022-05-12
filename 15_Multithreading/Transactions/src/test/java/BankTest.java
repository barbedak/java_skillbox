import org.junit.Test;

import static org.junit.Assert.*;

public class BankTest {

    @Test
    public void transfer() throws InterruptedException {
        Account fromAccount = new Account("1", 60000, false);
        Account toAccount = new Account("2", 70000, false);

        Bank bank = new Bank();
        bank.addAccount(fromAccount);
        bank.addAccount(toAccount);
        bank.transfer(fromAccount.getAccNumber(), toAccount.getAccNumber(), 5000);

        long expectedBalanceFromAccount = 55000;
        long expectedBalanceToAccount = 75000;
        long actualBalanceFromAccount = fromAccount.getMoney();
        long actualBalanceToAccount = toAccount.getMoney();
        long expectedBankBalance = 130000;
        long actualBankBalance = actualBalanceFromAccount + actualBalanceToAccount;
        assertEquals(expectedBalanceFromAccount, actualBalanceFromAccount);
        assertEquals(expectedBalanceToAccount, actualBalanceToAccount);
        assertEquals(expectedBankBalance, actualBankBalance);
    }

    @Test
    public void getBalance() {
        Account acc = new Account("1", 50000, false);
        Bank bank = new Bank();
        bank.addAccount(acc);
        long expectedBalance = bank.getBalance(acc.getAccNumber());
        long actualBalance = acc.getMoney();
        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void getSumAllAccounts() {
        Account accFirst = new Account("1", 1000, false);
        Account accSecond = new Account("2", 2000, false);
        Bank bank = new Bank();
        bank.addAccount(accFirst);
        bank.addAccount(accSecond);
        long expectedSum = 3000;
        long actualSum = bank.getSumAllAccounts();
        assertEquals(expectedSum, actualSum);
    }
}