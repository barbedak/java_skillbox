import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Site {
    private final String url;
    private List<String> children = new ArrayList<>();

    public Site(String link) {
        this.url = link;
    }

    public List<String> getChildren() {
        return children;
    }

    public void fillChildren() {
        try {
            Thread.sleep(150);
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href$=/]");
            links.forEach((link) -> {
                String href = link.attr("abs:href").trim();
                boolean isCorrectStartLink = href.startsWith(Main.ROOT_URL);
                boolean isInRootLinks = Main.nodeList.contains(href);

                if (isCorrectStartLink && !isInRootLinks) {
                    children.add(href);
                    Main.nodeList.add(href);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return url;
    }
}
