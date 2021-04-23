import java.time.LocalDate;

public class DepositAccount extends BankAccount{

    private LocalDate lastIncome;

    public DepositAccount() {
        super();
    }
    public DepositAccount(double amount) {
        super(amount);
        LocalDate dateNow = LocalDate.now();
        setLastIncome(dateNow);
    }

    public LocalDate getLastIncome() {
        return lastIncome;
    }

    private void setLastIncome(LocalDate lastIncome) {
        this.lastIncome = lastIncome;
    }
}
