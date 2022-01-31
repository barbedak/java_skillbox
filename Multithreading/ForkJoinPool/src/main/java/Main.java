import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static final String ROOT_URL = "https://lenta.ru";

    public static List<String> arrayLinks = new ArrayList<>();

    public static void main(String[] args) {

        Site root = new Site(ROOT_URL);

        String result = new ForkJoinPool().invoke(new SiteNameParser(root));
        writeToFile(result);
    }

    private static void writeToFile(String link) {

        try {
            FileWriter writer = new FileWriter("data/out.txt", true);
            writer.write(link);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
