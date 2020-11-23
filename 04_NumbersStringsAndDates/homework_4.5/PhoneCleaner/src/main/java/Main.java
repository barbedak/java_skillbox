import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }

      Pattern patternNotNumbers = Pattern.compile("[^0-9]");
      Matcher matcherNotNumbers = patternNotNumbers.matcher(input);
      input = matcherNotNumbers.replaceAll("");

      Pattern patternStartEight = Pattern.compile("^8");
      Matcher matcherStartEight = patternStartEight.matcher(input);
      input = matcherStartEight.replaceAll("7");
      if (input.charAt(0) != '7') {
        input = "7" + input;
      }
      if(input.length() == 11){
        System.out.println(input);
      } else {
        System.out.println("Неверный формат номера");
      }
    }
  }

}
