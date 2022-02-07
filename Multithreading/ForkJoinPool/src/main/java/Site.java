import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Site {
    private String url;
    private List<Site> children = new ArrayList<>();

    public Site(String link) {
        this.url = link;
    }

    public List<Site> getChildren() {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href^=" + Main.ROOT_URL + "]");
            links.forEach((link) -> {
                String href = link.attr("abs:href");
                if (!Main.allLinks.contains(href.trim())) {
                    Main.allLinks.add(href);
                    children.add(new Site(href));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return children;
    }

    public String getUrl() {
        return url;
    }
}
