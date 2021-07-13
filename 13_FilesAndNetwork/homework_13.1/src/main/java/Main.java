import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите путь : ");
            long folderSize;
            String patch = scanner.nextLine();
            try {
                File directory = new File(patch);
                if (directory.isFile() || !directory.exists()) {
                    System.out.println("Такой папки нет!");
                    continue;
                }
                folderSize = FileUtils.calculateFolderSize(patch);
                System.out.println("Размер папки : " + formatFolderSize(folderSize));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String formatFolderSize(long size) {
        double kilobytes = size / 1000.0;
        double megabytes = kilobytes / 1000;
        double gigabytes = megabytes / 1000;
        if (kilobytes < 1) {
            return size + " byte";
        } else if (megabytes < 1) {
            return String.format("%.1f", kilobytes) + " Kb";
        } else if (gigabytes < 1) {
            return String.format("%.1f", megabytes) + " Mb";
        }
        return String.format("%.1f", gigabytes) + " Gb";
    }
}
