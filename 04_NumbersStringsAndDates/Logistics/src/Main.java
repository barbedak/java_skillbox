import java.util.Scanner;

public class Main {
    public static int amountBox;
    public static int amountContainer;
    public static int amountTruck;
    public static int containerInTruck = 12;
    public static int boxInContainer = 27;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество коробок : ");
        amountBox = scanner.nextInt();
        System.out.println();

        amountContainer = amountBox / boxInContainer;
        if (amountBox % boxInContainer > 0) {
            amountContainer ++;
        }

        amountTruck = amountContainer / containerInTruck;
        if (amountContainer % containerInTruck > 0) {
            amountTruck++;
        }

        int currentBox = 0;
        int currentContainer = 0;
        int maxContainer;
        int maxBox;

        for (int i = 1; i <= amountTruck; i++){
            System.out.println("Грузовик "+ i + ":");

            maxContainer = (Math.min(amountContainer - currentContainer, containerInTruck));
            for (int k = 1; k <= maxContainer; k++){
                System.out.println("Контейнер "+ (k + currentContainer) +":");

                maxBox = (Math.min(amountBox - currentBox, boxInContainer));
                for (int j = 1; j <= maxBox; j++){
                    System.out.println("\tЯщик " + (j + currentBox));
                }
                currentBox += boxInContainer;
                System.out.println();

            }
            currentContainer+=maxContainer;
        }

        System.out.println("Необходимо:");
        System.out.println("грузовиков - " + amountTruck + " шт.");
        System.out.println("контейнеров - " + amountContainer + " шт.");
    }
}
