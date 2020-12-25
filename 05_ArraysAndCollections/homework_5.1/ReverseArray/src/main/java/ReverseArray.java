public class ReverseArray {

    //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.
    public static String[] reverse (String[] strings){
        int lastElement = strings.length - 1;
        for (int i = 0; i <= strings.length / 2; i++) {
            String buffer = strings[i];
            strings[i] = strings[lastElement - i];
            strings[lastElement - i] = buffer;
        }
        return strings;
    }
}
