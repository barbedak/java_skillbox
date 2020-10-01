
public class Loader
{
    public static void main(String[] args)
    {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        System.out.println(text);
        int sum = 0;

        String stringMoney = "";

        for (int i = 0; i < text.length(); i++){
            if (Character.isDigit(text.charAt(i))){
                stringMoney = stringMoney.concat(String.valueOf(text.charAt(i)));
            } else {
                if (stringMoney.length() > 0){
                    sum += Integer.parseInt(stringMoney);
                    stringMoney = "";
                }
           }
        }
        System.out.println("Первый вариант подсчета суммы заработка : " + sum);

        sum = 0;
        int indexSpace;
        String word;
        text = text.trim();

        while (text.length() > 0) {
            indexSpace = text.indexOf((char) 32);
            if (indexSpace != -1) {
                word = text.substring(0, indexSpace);
                indexSpace++;
                text = text.substring(indexSpace);
            } else {
                break;
            }

            if (Character.isDigit(word.charAt(0))){
                sum += Integer.parseInt(word);
            }
        }

        System.out.println("Второй вариант подсчета суммы заработка : " + sum);
    }

}