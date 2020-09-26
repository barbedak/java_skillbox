import java.util.Scanner;

public class Main {
    public static int amountBox;
    public static int amountContainer = 1;
    public static int amountTruck = 1;
    public static int containerInTruck = 12;
    public static int boxInContainer = 27;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество коробок : ");
        amountBox = scanner.nextInt();
        System.out.println();

        System.out.println("Грузовик " + amountTruck + ":");
        System.out.println("Контейнер " + amountContainer + ":");

        for (int box = 1; box <= amountBox; box++){
            System.out.println("\tЯщик " + box);
            if (box % boxInContainer == 0){
                amountContainer++;
                if (amountContainer % containerInTruck == 1){
                    amountTruck++;
                    System.out.println();
                    System.out.println("Грузовик " + amountTruck + ":");
                }
                System.out.println("Контейнер " + amountContainer + ":");
            }

        }
        System.out.println();
        System.out.println("Необходимо:");
        System.out.println("грузовиков - " + amountTruck + " шт.");
        System.out.println("контейнеров - " + amountContainer + " шт.");
    }
}
