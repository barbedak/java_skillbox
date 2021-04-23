public class CardAccount extends BankAccount {
    private final double COMMISSION = 0.01;

    public CardAccount() {
        super();
    }

    public CardAccount(double amount) {
        super(amount);
    }

    @Override
    public boolean take(double amountToTake) {
        amountToTake = amountToTake * COMMISSION + amountToTake;
        return super.take(amountToTake);
    }
}
