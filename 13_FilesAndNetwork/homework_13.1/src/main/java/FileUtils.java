import java.io.File;

public class FileUtils {
    public static long calculateFolderSize(String folderPath) {
        long folderSize = 0;
        File folder = new File(folderPath);
        try {
            String[] names = folder.list();
            for (String path : names) {
                path = folderPath + "\\" + path;
                File file = new File(path);
                if (file.isDirectory()) {
                    folderSize += calculateFolderSize(path);
                    continue;
                }
                folderSize += file.length();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return folderSize;
    }
}
