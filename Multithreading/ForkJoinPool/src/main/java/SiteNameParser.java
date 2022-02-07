import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.RecursiveTask;

public class SiteNameParser extends RecursiveTask<Map<String, List<Site>>> {
    private Site site;

    public SiteNameParser(Site site) {
        this.site = site;
    }


    @Override
    protected Map<String, List<Site>> compute() {

        Map<String, List<Site>> mapSite = new TreeMap<>();
        List<SiteNameParser> taskList = new ArrayList<>();
        List<Site> children = site.getChildren();

        mapSite.put(site.getUrl(), children);

        for (Site child : children) {
            SiteNameParser task = new SiteNameParser(child);
            task.fork();
            try {
                Thread.sleep(120);
            } catch (Exception e) {
                e.printStackTrace();
            }
            taskList.add(task);
        }

        for (SiteNameParser task : taskList) {
            mapSite.putAll(task.join());
        }
        return mapSite;
    }
}
