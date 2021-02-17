import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook contacts = new PhoneBook();
        String name;
        String phone;

        for (; ; ) {
            System.out.println("Введите номер, имя или команду:");
            String input = scanner.nextLine();

            if (input.equals("LIST")) {
                printPhoneBook(contacts);
                continue;
            }

            //введен номер телефона
            if (contacts.isValidPhone(input) && !contacts.isValidName(input)) {
                phone = input;
                boolean isNewPhone = !contacts.phoneBook.containsKey(phone);
                if (isNewPhone) {
                    System.out.println("Такого номера нет в телефонной книге.");
                    System.out.println("Введите имя абонента для номера " + phone + ":");
                    name = scanner.nextLine();
                    if (contacts.isValidName(name)) {
                        contacts.addContact(phone, name);
                        System.out.println("Контакт сохранен!");
                    }
                } else {
                    System.out.println(contacts.getNameByPhone(phone) + " - " + phone);
                }
            //введено имя
            } else if (contacts.isValidName(input) && !contacts.isValidPhone(input)) {
                name = input;
                boolean isNewName = !contacts.phoneBook.containsValue(name);
                if (isNewName) {
                    System.out.println("Такого имени в телефонной книге нет.");
                    System.out.println("Введите номер телефона для абонента " + name + ":");
                    phone = scanner.nextLine();
                    if (contacts.isValidPhone(phone)) {
                        contacts.addContact(phone, name);
                        System.out.println("Контакт сохранен!");
                    }
                } else {
                    System.out.println(contacts.getPhonesByName(name));
                }
            } else {
                System.out.println("Неверный формат ввода");
            }
        }
    }

    private static void printPhoneBook(PhoneBook contacts) {
        String checkedName;
        String name;
        String contactNumbers;
        ArrayList<String> checkedNameList = new ArrayList<>();
        for (String phone : contacts.phoneBook.keySet()) {
            contactNumbers = phone;
            checkedName = contacts.phoneBook.get(phone);
            for (String key : contacts.phoneBook.keySet()) {
                name = contacts.phoneBook.get(key);
                if (checkedNameList.contains(name)) {
                    continue;
                }
                if (checkedName.equals(name) && !phone.equals(key)) {
                    contactNumbers = contactNumbers.concat(", " + key);
                }
            }
            if (!checkedNameList.contains(checkedName)) {
                System.out.println(checkedName + " - " + contactNumbers);
            }
            checkedNameList.add(checkedName);
        }
    }
}
