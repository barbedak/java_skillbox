import java.time.LocalDate;

public class DepositAccount extends BankAccount {

    private LocalDate lastIncome;

    @Override
    public void take(double amountToTake) {
        LocalDate dateNow = LocalDate.now();
        if (dateNow.isAfter(lastIncome.plusMonths(1))){
            super.take(amountToTake);
        }
    }

    @Override
    public void put(double amountToPut) {
        super.put(amountToPut);
        setLastIncome(LocalDate.now());
    }

    public LocalDate getLastIncome() {
        return lastIncome;
    }

    public void setLastIncome(LocalDate lastIncome) {
        this.lastIncome = lastIncome;
    }
}
