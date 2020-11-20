import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        Pattern pattern = Pattern.compile("<.+?>");
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(placeholder);
        return text;
    }

}