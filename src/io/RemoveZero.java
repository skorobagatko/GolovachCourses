package io;

import java.io.*;

/**
 * Программа удаляет из переданного ей массива байт все байты равные 0
 * Записывать данные диапазонами без нулевых байт
 */
public class RemoveZero {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        File dst = new File("e:/b.txt");
        try {
            inputStream = new ByteArrayInputStream(new byte[]{0,78,67,0,89,85,0,0,72,82,85,77,0});
//            inputStream = new FileInputStream("e:/a.txt");
            outputStream = new FileOutputStream(dst);
//            ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
            long startTime = System.currentTimeMillis();
            copyWithoutZeroes(inputStream, outputStream, 64 * 1024);
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
//            System.out.println(elapsedTime);
//            System.out.println(Arrays.toString(outputStream1.toByteArray()));
        } catch (IOException e) {
            e.printStackTrace();
            if (dst.exists()) {
                boolean fileDeleted = dst.delete();
                if (!fileDeleted) {
                    e.addSuppressed(new IOException("Can't delete the file " + dst.getAbsolutePath()));
                }
            }
            throw new IOException("Some error was occure while trying copy to file " + dst.getAbsolutePath(), e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                    if (outputStream != null) {
                        try {
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e) {
                            // NOP
                        }
                    }
                } catch (IOException e) {
                    // NOP
                }
            }
        }
    }

    private static void copyWithoutZeroes(InputStream in, OutputStream out, int buffSize) throws IOException {
        byte[] buff = new byte[buffSize];
        int count;
        while ((count = in.read(buff)) != -1) {
            int startIndexOfCopiedSegment;
            int endIndexOfCopiedSegment;
            int segmentLength;
            for (int index = 0; index < count;) {
                if (buff[index] == 0) {
                    index++;
                    continue;
                }
                startIndexOfCopiedSegment = index;
                while (buff[index] != 0) { index++; }
                endIndexOfCopiedSegment = index-1;
                segmentLength = endIndexOfCopiedSegment - startIndexOfCopiedSegment;

                out.write(buff, startIndexOfCopiedSegment, segmentLength+1);
                out.flush();

                index++;
            }
        }
        out.flush();
    }
}
