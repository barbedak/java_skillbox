import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      input = input.replaceAll("[^0-9]","");
      input = input.replaceAll("^8","7");
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
