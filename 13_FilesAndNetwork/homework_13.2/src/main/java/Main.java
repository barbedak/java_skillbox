import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите папку, откуда копировать : ");
            String source = scanner.nextLine();
            System.out.print("Введите папку, куда копировать : ");
            String destination = scanner.nextLine();
            File sourceFolder = new File(source);
            File destinationFolder = new File(destination);
            if (sourceFolder.isDirectory() && destinationFolder.isDirectory()) {
                try {
                    FileUtils.copyFolder(source, destination);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                System.out.println("Неправильно указана папка-источник или целевая папка!");
            }
        }

    }
}
