public class CardAccount extends BankAccount {

    @Override
    public boolean take(double amountToTake) {
        amountToTake = amountToTake * 0.01 + amountToTake;
        return super.take(amountToTake);
    }
}
