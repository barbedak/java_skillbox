import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {
    private final TreeSet<String> emailList = new TreeSet<>();

    public static boolean isValidEmail(String email)
    {
        Pattern pattern = Pattern.compile("\\w+@\\w+\\.\\w+");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public void add(String email) {
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
        ArrayList<String> list = new ArrayList<>();
        list.addAll(emailList);
        return list;
    }
}
