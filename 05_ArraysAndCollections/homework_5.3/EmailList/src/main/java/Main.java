import java.util.Scanner;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmailList emailList = new EmailList();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("0")) {
                break;
            }
            
            String[] inputArgs = input.split("\\s");
            String command = inputArgs[0];

            if(command.equals("ADD"))
            {
               emailList.add(inputArgs[1]);
            }

            if (command.equals("LIST"))
            {
                for (String email : emailList.getSortedEmails())
                {
                    System.out.println(email);
                }
            }
        }
    }
}
