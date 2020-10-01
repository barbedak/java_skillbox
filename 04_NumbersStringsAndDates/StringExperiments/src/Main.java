public class Main {
    public static void main(String[] args) {
        for (int i = 'a'; i <= 'z'; i++){
            System.out.println((char) i + " - " + i);
        }
        for (int i = 'A'; i <= 'Z'; i++){
            System.out.println((char) i + " - " + i);
        }

        System.out.println();
        for (int i = 'а'; i <= 'я'; i++){
            System.out.println((char) i + " - " + i);
        }
        for (int i = 'А'; i <=  'Я'; i++){
            System.out.println((char) i + " - " + i);
        }
    }
}
