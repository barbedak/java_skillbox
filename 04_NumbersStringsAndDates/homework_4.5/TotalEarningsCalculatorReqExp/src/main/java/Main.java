public class Main {

  public static void main(String[] args) {

  }

  public static int calculateSalarySum(String text){
    //TODO: реализуйте метод
    text = text.replaceAll("[^0-9]+", " ").trim();

    if (text.length() == 0) {
      return 0;
    }

    String[] salary = text.split(" ");
    int sum = 0;
    for (String s : salary) {
      sum = sum + Integer.parseInt(s);
    }
    return sum;
  }

}