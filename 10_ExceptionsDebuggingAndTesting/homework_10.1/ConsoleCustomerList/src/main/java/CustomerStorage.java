import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    private boolean checkEmail(String email){
        return email.matches("[a-zA-Z_0-9.]+@[a-zA-Z_0-9]+\\.[a-zA-Z_0-9]+");
    }

    private boolean checkPhoneNumber (String number){
        if (number.length() != 12) {
            return false;
        }
        return number.matches("^\\+7[0-9]+");
    }

    public void addCustomer(String data) throws IncorrectPhoneNumberException, IncorrectEmailException, IllegalCommandException {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");

        if (components.length != 4) {
            throw new IllegalCommandException("Wrong amount of parameters!", data);
        }

        if (!checkEmail(components[INDEX_EMAIL])) {
            throw new IncorrectEmailException("Wrong e-mail!", components[INDEX_EMAIL]);
        }

        if (!checkPhoneNumber(components[INDEX_PHONE])) {
            throw new IncorrectPhoneNumberException("Wrong phone!", components[INDEX_PHONE]);
        }

        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        try {
            storage.remove(name);
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
        }
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}