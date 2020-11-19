import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {
  }

  public static int calculateSalarySum(String text){
    //TODO: реализуйте метод
    int sum = 0;
    Pattern pattern = Pattern.compile("\\d+");
    Matcher matcher = pattern.matcher(text);

    while (matcher.find()){
      sum += Integer.parseInt(matcher.group());
    }
    return sum;
  }

}