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
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО

      Pattern pattern = Pattern.compile("\\s");
      String[] fio = pattern.split(input);

      if (fio.length == 3){
        pattern = Pattern.compile("[а-яА-Я-]+");
        Matcher surname = pattern.matcher(fio[0]);
        Matcher name = pattern.matcher(fio[1]);
        Matcher patronymic = pattern.matcher(fio[2]);

        if (surname.find() && name.find() && patronymic.find()){
          System.out.println("Фамилия: " + fio[0]);
          System.out.println("Имя: " + fio[1]);
          System.out.println("Отчество: " + fio[2]);
        } else {
          System.out.println("Введенная строка не является ФИО");
        }
      } else {
        System.out.println("Введенная строка не является ФИО");
      }
    }
  }

}