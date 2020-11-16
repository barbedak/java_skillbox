public class Main {

  public static void main(String[] args) {
    System.out.println(splitTextInToWords(""));
  }

  public static String splitTextInToWords(String text) {
    //TODO реализуйте метод
    if (text.length()==0){
      return text;
    }
    text = text.replaceAll("[^a-zA-Z’]", " ").trim();
    text = text.replaceAll("[ ]+", " ");
    String[] result = text.split(" ");
    text = result[0];
    for (int i = 1; i < result.length; i++){
      text = text.concat("\n");
      text = text.concat(result[i]);
    }
    return text;
  }
}