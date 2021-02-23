import java.util.*;

public class Main {

    public static void main(String[] args) {
        long startTime;
        long endTime;
        boolean isNumberFind;
        String searchNumber = "Р555ОК53";
        List<String> carNumbers = CoolNumbers.generateCoolNumbers();

        startTime = System.nanoTime();
        isNumberFind = CoolNumbers.bruteForceSearchInList(carNumbers, searchNumber);
        endTime = System.nanoTime();
        System.out.print("Поиск перебором: ");
        if (isNumberFind) {
            System.out.print("номер найден");
        } else {
            System.out.print("номер не найден");
        }
        System.out.println(", поиск занял " + (endTime - startTime) + "нс");

        Collections.sort(carNumbers);
        startTime = System.nanoTime();
        isNumberFind = CoolNumbers.binarySearchInList(carNumbers, searchNumber);
        endTime = System.nanoTime();
        System.out.print("Бинарный поиск: ");
        if (isNumberFind) {
            System.out.print("номер найден");
        } else {
            System.out.print("номер не найден");
        }
        System.out.println(", поиск занял " + (endTime - startTime) + "нс");

        HashSet<String> carNumbersHash = new HashSet<>(carNumbers);
        startTime = System.nanoTime();
        isNumberFind = CoolNumbers.searchInHashSet(carNumbersHash, searchNumber);
        endTime = System.nanoTime();
        System.out.print("Поиск в HashSet: ");
        if (isNumberFind) {
            System.out.print("номер найден");
        } else {
            System.out.print("номер не найден");
        }
        System.out.println(", поиск занял " + (endTime - startTime) + "нс");

        TreeSet<String> carNumbersTree = new TreeSet<>(carNumbers);
        startTime = System.nanoTime();
        isNumberFind = CoolNumbers.searchInTreeSet(carNumbersTree, searchNumber);
        endTime = System.nanoTime();
        System.out.print("Поиск в TreeSet: ");
        if (isNumberFind) {
            System.out.print("номер найден");
        } else {
            System.out.print("номер не найден");
        }
        System.out.println(", поиск занял " + (endTime - startTime) + "нс");
    }
}
