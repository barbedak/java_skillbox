public class Main {
    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions();
        dimensions = dimensions.setHeight(5);
        dimensions = dimensions.setWidth(6);
        dimensions = dimensions.setDepth(1);
        Cargo cargo = new Cargo();
        System.out.println(cargo);
        System.out.println();
        cargo = cargo.setDimensions(dimensions);
        cargo = cargo.setWeight(5);
        System.out.println(cargo);

    }
}