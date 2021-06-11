import java.util.Scanner;

public class Main {
    private static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
            COMMAND_EXAMPLES;
    private static final String helpText = "Command examples:\n" + COMMAND_EXAMPLES;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();

        while (true) {
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+", 2);

            if (tokens[0].equals("add")) {
                try {
                    executor.addCustomer(tokens[1]);
                } catch (IllegalCommandException ex){
                    System.out.println(ex.getMessage() + ' ' + ex.getCommand());
                    System.out.println(helpText);
                } catch (IncorrectPhoneNumberException ex) {
                    System.out.println(ex.getMessage() + ' ' + ex.getNumber());
                    System.out.println(helpText);
                } catch (IncorrectEmailException ex) {
                    System.out.println(ex.getMessage() + ' ' + ex.getParmeter());
                    System.out.println(helpText);
                }
            } else if (tokens[0].equals("list")) {
                executor.listCustomers();
            } else if (tokens[0].equals("remove")) {
                try {
                    executor.removeCustomer(tokens[1]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println(COMMAND_ERROR);
                }
            } else if (tokens[0].equals("count")) {
                System.out.println("There are " + executor.getCount() + " customers");
            } else if (tokens[0].equals("help")) {
                System.out.println(helpText);
            } else {
                System.out.println(COMMAND_ERROR);
            }
        }
    }
}
