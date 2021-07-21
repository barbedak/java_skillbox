import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {
        File sourceFolder = new File(sourceDirectory);
        String[] namesOfFilesInFolder = sourceFolder.list();
        for (String fileName : namesOfFilesInFolder) {
            File sourceFile = new File(sourceDirectory + "\\" + fileName);
            if (sourceFile.isDirectory()) {
                Files.createDirectory(Path.of(destinationDirectory + "\\" + fileName));
                copyFolder(sourceFile.toPath().toString(), destinationDirectory + "\\" + fileName);
                continue;
            }
            File destinationFile = new File(destinationDirectory + "\\" + fileName);
            Files.copy(sourceFile.toPath(), destinationFile.toPath());
        }
        System.out.println("Файлы из '" + sourceDirectory + "' в '" + destinationDirectory + "' скопированы!");
    }
}
