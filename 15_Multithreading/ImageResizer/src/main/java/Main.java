import java.io.File;

public class Main {
    private final static int NUMBER_OF_CORE = 4;

    public static void main(String[] args) {
        String srcFolder = "e:/from";
        String dstFolder = "e:/to";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();
        int part = files.length / NUMBER_OF_CORE;
        int startCopyPosition = 0;

        if (NUMBER_OF_CORE > 1) {
            for (int i = 1; i < NUMBER_OF_CORE; i++) {
                File[] files1 = new File[part];
                System.arraycopy(files, startCopyPosition, files1, 0, files1.length);
                startCopyPosition += files1.length;
                new Thread(new ImageResize(files1, dstFolder, start)).start();
            }
        }
        File[] files1 = new File[files.length - part * NUMBER_OF_CORE + part];
        System.arraycopy(files, startCopyPosition, files1, 0, files1.length);
        new Thread(new ImageResize(files1, dstFolder, start)).start();
    }
}
