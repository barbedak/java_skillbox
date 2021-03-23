public class Cargo{
    private final Dimensions dimensions;
    private final double weight;
    private final String address;
    private final boolean isTurnOver;
    private final String registrationNumber;
    private final boolean isFragile;

    public Cargo(){
        dimensions = new Dimensions();
        weight = 0.0;
        address = "N/A";
        isTurnOver = false;
        registrationNumber = "N/A";
        isFragile = false;
    }

    public Cargo(Dimensions dimensions,
                 double weight,
                 String address,
                 boolean isTurnOver,
                 String registrationNumber,
                 boolean isFragile) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.address = address;
        this.isTurnOver = isTurnOver;
        this.registrationNumber = registrationNumber;
        this.isFragile = isFragile;
    }

    public Cargo setDimensions(Dimensions dimensions){
        return new Cargo(dimensions, weight, address, isTurnOver, registrationNumber, isFragile);
    }

    public Cargo setWeight(double weight){
        return new Cargo(dimensions, weight, address, isTurnOver, registrationNumber, isFragile);
    }

    public Cargo setAddress(String address){
        return new Cargo(dimensions, weight, address, isTurnOver, registrationNumber, isFragile);
    }

    public Cargo setIsTurnOver(boolean isTurnOver){
        return new Cargo(dimensions, weight, address, isTurnOver, registrationNumber, isFragile);
    }

    public Cargo setRegistrationNumber(String registrationNumber){
        return new Cargo(dimensions, weight, address, isTurnOver, registrationNumber, isFragile);
    }

    public Cargo setIsFragile(boolean isFragile){
        return new Cargo(dimensions, weight, address, isTurnOver, registrationNumber, isFragile);
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public double getWeight() {
        return weight;
    }

    public String getAddress() {
        return address;
    }

    public boolean isTurnOver() {
        return isTurnOver;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public String toString(){
        return "dimensions : \n" + dimensions +
               "\nweight : " + weight +
               "\naddress : " + address +
               "\nisTurnOver : " + isTurnOver +
               "\nregistration number : " + registrationNumber +
               "\nisFragile : " + isFragile;
    }
}