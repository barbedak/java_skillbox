public class CardAccount extends BankAccount {

    @Override
    public void take(double amountToTake) {
        amountToTake = amountToTake * 0.01 + amountToTake;
        super.take(amountToTake);
    }
}
