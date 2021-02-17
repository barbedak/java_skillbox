import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    public final TreeMap<String, String> phoneBook = new TreeMap<>(); //<phone : name>

    public boolean isValidPhone(String phone){
        Pattern patternNumbers = Pattern.compile("7[0-9]");
        Matcher matcherNumbers = patternNumbers.matcher(phone);
        if (phone.length() == 11 && matcherNumbers.find()){
            return true;
        }
        return false;
    }

    public boolean isValidName(String name){
        Pattern patternName = Pattern.compile("[A-ZА-Я][a-zа-я]+");
        Matcher matcherName = patternName.matcher(name);
        if (name.length() > 0 && matcherName.find()){
            return true;
        }
        return false;
    }

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
        if (isValidName(name) && isValidPhone(phone)){
            phoneBook.put(phone, name);
        }
    }

    public String getNameByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        if (phoneBook.containsKey(phone)){
            String contact;
            contact = phoneBook.get(phone) + " - " + phone;
            return contact;
        }
        return "";
    }

    public Set<String> getPhonesByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        TreeSet<String> contacts = new TreeSet<>();
        for (String key : phoneBook.keySet()){
            if (phoneBook.get(key).equals(name)){
                contacts.add(name + " - " + key);
            }
        }
        return contacts;
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        TreeSet<String> contacts = new TreeSet<>();
        for (String phone : phoneBook.keySet()){
            contacts.add(phoneBook.get(phone) + " - " + phone);
        }
        return contacts;
    }

}