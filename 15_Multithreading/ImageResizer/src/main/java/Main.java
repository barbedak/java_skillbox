import java.io.File;

public class Main {
    private final static int NUMBER_OF_CORE = 4;

    public static void main(String[] args) {
        String srcFolder = "e:/from";
        String dstFolder = "e:/to";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();
       
        if (NUMBER_OF_CORE > 1) {
            int startCopyPosition = 0;
            int remainder = files.length % NUMBER_OF_CORE;
            int proportion;
            for (int i = 1; i < NUMBER_OF_CORE; i++) {
                proportion = files.length / NUMBER_OF_CORE;
                if (remainder > 0) {
                    proportion++;
                    remainder--;
                }
                File[] files1 = new File[proportion];
                System.arraycopy(files, startCopyPosition, files1, 0, files1.length);
                startCopyPosition += files1.length;
                new Thread(new ImageResize(files1, dstFolder, start)).start();
            }
        }
        new Thread(new ImageResize(files, dstFolder, start)).start();
    }
}
