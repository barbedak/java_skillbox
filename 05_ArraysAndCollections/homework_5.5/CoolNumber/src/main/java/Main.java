import java.util.*;

public class Main {

    public static void main(String[] args) {
        int midDurationBruteForceSearch;
        int midDurationBinarySearchInList;
        int midDurationSearchInHashSet;
        int midDurationSearchInTreeSet;
        int sumDurationsBruteForceSearch = 0;
        int sumDurationsBinarySearchInList = 0;
        int sumDurationsSearchInHashSet = 0;
        int sumDurationsSearchInTreeSet = 0;
        String searchNumber = CoolNumbers.generateCoolNumber();
        List<String> carNumbers = CoolNumbers.generateCoolNumbers();
        ArrayList<String> carNumbersSorted = new ArrayList<>(carNumbers);
        Collections.sort(carNumbersSorted);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите количество проверяемых номеров");
        int numberOfChecks = scanner.nextInt();

        for (int i = 0; i < numberOfChecks; i++){
            sumDurationsBruteForceSearch += bruteForceSearch(searchNumber,carNumbers);
            sumDurationsBinarySearchInList += binarySearchInList(searchNumber, carNumbersSorted);
            sumDurationsSearchInHashSet += searchInHashSet(searchNumber,carNumbersSorted);
            sumDurationsSearchInTreeSet += searchInTreeSet(searchNumber, carNumbersSorted);
            searchNumber = CoolNumbers.generateCoolNumber();
        }
        midDurationBruteForceSearch = sumDurationsBruteForceSearch / numberOfChecks;
        midDurationBinarySearchInList = sumDurationsBinarySearchInList / numberOfChecks;
        midDurationSearchInHashSet = sumDurationsSearchInHashSet / numberOfChecks;
        midDurationSearchInTreeSet = sumDurationsSearchInTreeSet / numberOfChecks;

        System.out.println("Среднее время поиска перебором: " + midDurationBruteForceSearch + " нс");
        System.out.println("Средене время бинарного поиска : " + midDurationBinarySearchInList + " нс");
        System.out.println("Средене время поиска HashSet: " + midDurationSearchInHashSet + " нс");
        System.out.println("Средене время поиска TreeSet: " + midDurationSearchInTreeSet + " нс");
    }

    private static int searchInTreeSet (String searchNumber, List<String> carNumbers) {
        long startTime;
        long endTime;
        boolean isNumberFind;
        TreeSet<String> carNumbersTree = new TreeSet<>(carNumbers);
        startTime = System.nanoTime();
        isNumberFind = CoolNumbers.searchInTreeSet(carNumbersTree, searchNumber);
        endTime = System.nanoTime();
        return (int)(endTime - startTime);
    }

    private static int searchInHashSet (String searchNumber, List<String> carNumbers) {
        long startTime;
        long endTime;
        boolean isNumberFind;
        HashSet<String> carNumbersHash = new HashSet<>(carNumbers);
        startTime = System.nanoTime();
        isNumberFind = CoolNumbers.searchInHashSet(carNumbersHash, searchNumber);
        endTime = System.nanoTime();
        return (int)(endTime - startTime);
    }

    private static int binarySearchInList (String searchNumber, List<String> carNumbers) {
        long startTime;
        long endTime;
        boolean isNumberFind;
        startTime = System.nanoTime();
        isNumberFind = CoolNumbers.binarySearchInList(carNumbers, searchNumber);
        endTime = System.nanoTime();
        return (int)(endTime - startTime);
    }
    private static int bruteForceSearch(String searchNumber, List<String> carNumbers){
        long startTime;
        long endTime;
        boolean isNumberFind;
        startTime = System.nanoTime();
        isNumberFind = CoolNumbers.bruteForceSearchInList(carNumbers, searchNumber);
        endTime = System.nanoTime();
        return (int)(endTime - startTime);
    }
}
