public class Main {

    public static void main(String[] args) {

    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
        if (text.contains("<") && text.contains(">")) {
            int indexOpenDiamonds = text.indexOf("<");
            int indexCloseDiamonds = text.indexOf(">");
            text = text.substring(0, indexOpenDiamonds) + placeholder + text.substring(indexCloseDiamonds + 1);
        }
        return text;
    }
}