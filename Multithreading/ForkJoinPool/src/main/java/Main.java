import java.io.FileWriter;
import java.util.*;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static final String ROOT_URL = "https://skillbox.ru/";
    public static Map<String, List<String>> siteMap;
    public static Set<String> nodeList = new HashSet<>();

    public static void main(String[] args) {
        System.out.print("Make site map... ");
        nodeList.add(ROOT_URL);
        siteMap = new ForkJoinPool().invoke(new SiteLinkParser(ROOT_URL));
        System.out.println("Done!");
        save(ROOT_URL, "");
    }

    private static void save(String node, String prefix) {
        writeToFile(node + "\n");
//        prefix +="\t";
        try {
            List<String> children = siteMap.get(node);
            for (String child : children) {
                save(prefix + child, prefix+"\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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