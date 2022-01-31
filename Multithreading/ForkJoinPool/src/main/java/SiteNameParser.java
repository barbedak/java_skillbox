import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class SiteNameParser extends RecursiveTask<String> {
    private Site site;

    public SiteNameParser(Site site) {
        this.site = site;
    }

    @Override
    protected String compute() {
        String result = site.getUrl() + "\n";

        List<SiteNameParser> taskList = new ArrayList<>();

        for (Site child : site.getChildren()) {
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
            result = result.concat("\t" + task.join() + "\n");
        }
        return result;
    }
}
