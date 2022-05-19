import java.util.*;
import java.util.concurrent.RecursiveTask;

public class SiteLinkParser extends RecursiveTask<Map<String, List<String>>> {
    private final String url;

    public SiteLinkParser(String url) {
        this.url = url;
    }

    @Override
    protected Map<String, List<String>> compute() {
        Map<String, List<String>> map = new TreeMap<>();
        List<SiteLinkParser> subTaskList = new ArrayList<>();
        Site node = new Site(url);

        node.fillChildren();
        map.put(url, node.getChildren());
        for (String child : node.getChildren()) {
            SiteLinkParser task = new SiteLinkParser(child);
            task.fork();
            subTaskList.add(task);
        }
        for (SiteLinkParser task : subTaskList) {
            map.putAll(task.join());
        }
        return map;
    }
}
