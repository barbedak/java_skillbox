import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {
    private static TreeSet<String> emailList = new TreeSet<>();

    public EmailList(){
        emailList.clear();
    }

    public static boolean isValidEmail(String email)
    {
        Pattern pattern = Pattern.compile("\\w+@\\w+\\.\\w+");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public void add(String email) {
        // TODO: валидный формат email добавляется
        email = email.toLowerCase();
        if (isValidEmail(email))
        {
            emailList.add(email);
        } else
            {
                System.out.println(Main.WRONG_EMAIL_ANSWER);
            }
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается список электронных адресов в алфавитном порядке
        ArrayList<String> list = new ArrayList<>();
        list.addAll(emailList);
        return list;
    }

}
