import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        getLinksFromPage("https://lenta.ru");
    }

    private static void getLinksFromPage(String URL) {
        try {
            Document doc = Jsoup.connect(URL).get();
            Elements links = doc.select("a[href*=lenta.ru/]");
            int i = 0;
            for (Element link : links) {
                writeLinkToFile("", link.attr("abs:href"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeLinkToFile(String prefix, String link) {

        try {
            FileWriter writer = new FileWriter("data/out.txt", true);
            writer.write(prefix + link);
            writer.append("\n");
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
