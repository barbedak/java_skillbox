public class IndividualBusinessman extends Client {
    private final double baseCommission = 0.01;

    @Override
    public void put(double amountToPut) {
        double commission = baseCommission;
        if (amountToPut >= 1000) {
            commission = baseCommission / 2;
        }
        super.put(amountToPut - amountToPut * commission);
    }

    public void accountInfo() {
        System.out.println("Put - 1% if amount to put less then 1000 and 0.5% other, take - 0%");
    }
}
