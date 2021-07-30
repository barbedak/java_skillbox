import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;


public class Main {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://lenta.ru/").get();
        Elements element = doc.select("img.g-picture");
        System.out.println("Start downloading");
        element.forEach(el -> downloadFile(el.attr("abs:src")));
        System.out.println("Finish downloading");
    }

    public static void downloadFile(String url) {
        String fileName = "images/" + url.replaceAll("https://icdn.lenta.ru/images", "");
        String folderPath = fileName.replaceAll("/\\w+\\.jpg", "");
        File folder = new File(folderPath);
        if (folder.mkdirs()) {
            try {
                URL website = new URL(url);
                InputStream in = website.openStream();
                Files.copy(in, Path.of(fileName), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
