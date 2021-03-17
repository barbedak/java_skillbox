
import java.util.*;

public class CoolNumbers {

    public static char getLetter() {
        char[] letters = {'А','В','Е','К','М','Н','О','Р','С','Т','У','Х'};
        int i = (int) (Math.random()*11);
        return letters[i];
    }

    public static int getDigit() {
        return (int) (Math.random()*10);
    }

    public static String getRegion() {
        String region;
        int digit = (int) (1 + Math.random()*199);
        region = Integer.toString(digit);
        if (region.length() < 2) {
            region = "0" + region;
        }
        return region;
    }

    public static String generateCoolNumber(){
        /*
        * XYZ — различный набор из списка разрешенных букв, N — цифры, R — регион (от 01 до 199);
          XNNNYZR — пример: A111BC197, У777HC66.
          * буквы: А, В, Е, К, М, Н, О, Р, С, Т, У, Х
          * */
        String firstLetter;
        String secondLetter;
        String thirdLetter;
        int digit;
        String region;
        String coolNumber;
        firstLetter = String.valueOf(getLetter());
        secondLetter = String.valueOf(getLetter());
        thirdLetter = String.valueOf(getLetter());
        digit = getDigit();
        region = getRegion();
        coolNumber = firstLetter + digit + digit + digit + secondLetter + thirdLetter + region;
        return coolNumber;
    }

    public static List<String> generateCoolNumbers() {
        List<String> numbersList = new ArrayList<>();
        for (int i = 0; i < 20003; i++ ) {
            numbersList.add(generateCoolNumber());
        }
        return numbersList;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        for (String elem : list){
            if (elem.equals(number)) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        return Collections.binarySearch(sortedList, number) >= 0;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }

}
