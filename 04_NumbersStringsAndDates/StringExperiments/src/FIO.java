import java.util.Scanner;

public class FIO {
    public static void main(String[] args) {
        String text = "", firstName = "", secondName = "", patronymic = "";
        boolean isCompleteSecondName = false, isCompleteFirstName = false;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ФИО : " + text);
        text = scanner.nextLine();

        text = text.trim();

        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) != ' '){
                if (!isCompleteSecondName) {
                    secondName = secondName.concat(String.valueOf(text.charAt(i)));
                }
                if (!isCompleteFirstName & isCompleteSecondName) {
                    firstName = firstName.concat(String.valueOf(text.charAt(i)));
                }
                if (isCompleteFirstName & isCompleteSecondName) {
                    patronymic = patronymic.concat(String.valueOf(text.charAt(i)));
                }
            } else {
                if (isCompleteSecondName & isCompleteFirstName) { break; }
                if (isCompleteSecondName) { isCompleteFirstName = true;}
                if (!isCompleteSecondName) { isCompleteSecondName = true;}

            }
        }

        System.out.println();
        System.out.println("Фамилия : " + secondName);
        System.out.println("Имя : " + firstName);
        System.out.println("Отчетство : " + patronymic);
    }
}
