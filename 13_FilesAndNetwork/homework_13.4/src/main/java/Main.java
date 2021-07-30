import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;


public class Main {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://lenta.ru/").get();
        Elements element = doc.select("img.g-picture");
        System.out.println("Start downloading");
        element.forEach(el -> downloadFile(el.attr("abs:src")));
        System.out.println("Finish downloading");
    }

    public static void downloadFile(String url) {
        String nameFile = "images/" + url.replaceAll("https://icdn.lenta.ru/images", "");
        createFoldersAndFile(nameFile);
        try {
            URL link = new URL(url);
            ReadableByteChannel rbc = Channels.newChannel(link.openStream());
            FileOutputStream fos = new FileOutputStream(nameFile);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
            rbc.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void createFoldersAndFile(String pathToFile) {
        String pathFolder = pathToFile.replaceAll("/\\w+\\.jpg", "");
        try {
            File folder = new File(pathFolder);
            folder.mkdirs();
            File file = new File(pathToFile);
            file.createNewFile();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
