public class IndividualBusinessman extends Client {
    private final double BASE_COMMISION = 0.01;

    @Override
    public void put(double amountToPut) {
        double commission = BASE_COMMISION;
        if (amountToPut >= 1000) {
            commission = BASE_COMMISION / 2;
        }
        super.put(amountToPut - amountToPut * commission);
    }

    public void accountInfo() {
        System.out.println("Put - 1% if amount to put less then 1000 and 0.5% other, take - 0%");
    }
}
