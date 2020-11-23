import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

  }

  public static String splitTextInToWords(String text) {
    String outputText = "";
    Pattern pattern = Pattern.compile("[a-zA-Z’]+");
    Matcher matcher = pattern.matcher(text);
    while (matcher.find()){
      outputText = outputText.concat(matcher.group());
      outputText = outputText.concat("\n");
    }
    return outputText.trim();
  }
}