public class CardAccount extends BankAccount {
    private final double commission = 0.01;

    public CardAccount() {
        super();
    }

    public CardAccount(double amount) {
        super(amount);
    }

    @Override
    public boolean take(double amountToTake) {
        amountToTake = amountToTake * commission + amountToTake;
        return super.take(amountToTake);
    }
}
