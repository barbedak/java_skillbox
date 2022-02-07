import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static final String ROOT_URL = "https://skillbox.ru/";
    public static List<String> allLinks = new ArrayList<>();
    public static Map<String, List<Site>> mapRootSite;

    public static void main(String[] args) {
        Site root = new Site(ROOT_URL);
        System.out.print("Make site map... ");
        mapRootSite = new ForkJoinPool().invoke(new SiteNameParser(root));
        System.out.println("Done!");

        try {
            FileWriter writer = new FileWriter("data/out.txt", true);
            writer.write(makeStringToSave(ROOT_URL));
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String makeStringToSave(String site) {
        String out = site;
        for (Site child : mapRootSite.get(site)) {
            out.concat("\n\t" + makeStringToSave(child.getUrl()));
        }
        return out;
    }
}
