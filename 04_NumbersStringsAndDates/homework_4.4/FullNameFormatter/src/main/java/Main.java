import java.util.Scanner;

public class Main {

  public static Boolean isOnlyLetter(String word){
    for (int i = 0; i < word.length(); i++){
      if (Character.isDigit(word.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  public static String getWord (String input) {
    String word = "";
    int spaceIndex = input.indexOf(" ");
    if (spaceIndex != -1) {
      word = input.substring(0, spaceIndex);
    }
    return word;
  }

  public static void main(String[] args) {
    String firstName, secondName, patronymic;

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
      input = input.trim();
      secondName = getWord(input);

      if (!secondName.equals("") && isOnlyLetter(secondName)){
        input = input.substring(secondName.length() + 1);
        firstName = getWord(input);

        if (!firstName.equals("") && isOnlyLetter(firstName)){
          patronymic = input.substring(firstName.length() + 1);

          if (!patronymic.equals("") && isOnlyLetter(patronymic) && !patronymic.contains(" ")){
            System.out.println("Фамилия: " + secondName);
            System.out.println("Имя: " + firstName);
            System.out.println("Отчество: " + patronymic);
          } else {
            System.out.println("Введенная строка не является ФИО");
          }

        } else {
          System.out.println("Введенная строка не является ФИО");
        }
      } else {
        System.out.println("Введенная строка не является ФИО");
      }
    }
  }

}