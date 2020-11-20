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

      Pattern pattern = Pattern.compile("[^0-9]");
      Matcher matcher = pattern.matcher(input);
      input = matcher.replaceAll("");
      pattern = Pattern.compile("8");
      matcher = pattern.matcher(input);
      input = matcher.replaceAll("7");
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
