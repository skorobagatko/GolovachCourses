package io.look_for_big_image;

import java.io.*;
import java.nio.channels.FileChannel;

public class CopyDirLab {
    public static void main(String[] args) {
        copy(new File("e:/tmp"), new File("e:/tmp1"));
    }

    private static void copy(File src, File dst) {
        if (src.isDirectory()) {
            dst.mkdir();
            for (File elem : src.listFiles()) {
                    copy(elem, new File(dst, elem.getName()));
            }
        } else {
            try (FileInputStream inputStream = new FileInputStream(src);
                 FileOutputStream outputStream = new FileOutputStream(dst)) {
                FileChannel in = inputStream.getChannel();
                FileChannel out = outputStream.getChannel();
                long size = in.size();
                long count = 0;
                while (count < size) { count = in.transferTo(count, size, out); }
            } catch (IOException e) {
                dst.delete();
            }
        }
    }
}
