import java.io.File;

public class Main {

    public static void main(String[] args) {
        String srcFolder = "e:/from";
        String dstFolder = "e:/to";
        int numberOfCore = 4;

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();
        int part = files.length / numberOfCore;
        int startCopyPos = 0;

        for (int i = 1; i < numberOfCore; i++) {
            File[] files1 = new File[part];
            System.arraycopy(files, startCopyPos, files1, 0, files1.length);
            startCopyPos += files1.length;
            new Thread(new ImageResize(files1, dstFolder)).start();
        }

        File[] files1 = new File[files.length - part * numberOfCore + 1];
        System.arraycopy(files, startCopyPos, files1, 0, files1.length);
        new Thread(new ImageResize(files1, dstFolder)).start();

        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }
}
