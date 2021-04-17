public class LegalPerson extends Client {
    private double COMMISSION = 0.01;

    @Override
    public void take(double amountToTake) {
        super.take(amountToTake + amountToTake * COMMISSION);
    }

    @Override
    public void accountInfo() {
        System.out.println("Put - 0%, take - 1%");
    }
}
