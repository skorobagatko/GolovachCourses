package module4_io.look_for_big_image;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileLab {
    public static void main(String[] args) {
        List<File> bigImages = searchBigImages(new File("e:/tmp"));
        for (File elem : bigImages) {
            System.out.println(elem.toString());
        }
    }

    private static List<File> searchBigImages(File root) {
        if (root == null) { throw new IllegalArgumentException(); }
        List<File> result = new ArrayList<File>();
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                String fileName = file.toString();
                if (file.isFile() && file.length() > 1024 * 1024 && (fileName.endsWith(".jpg") |
                        fileName.endsWith(".png") | fileName.endsWith(".bmp"))) return true;
                return false;
            }};
        if (root.isFile()) {
            if (filter.accept(root)) { result.add(root); }
        } else {
            File[] files = root.listFiles(filter);
            result.addAll(Arrays.asList(files));
            for (File elem : root.listFiles()) {
                if (elem.isDirectory()) { result.addAll(searchBigImages(elem)); }
            }
        }
        return result;
    }
}
