public class LegalPerson extends Client {
    private double commission = 0.01;

    @Override
    public void take(double amountToTake) {
        super.take(amountToTake + amountToTake * commission);
    }

    @Override
    public void accountInfo() {
        System.out.println("Put - 0%, take - 1%");
    }
}
