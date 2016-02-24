package io;

import java.io.*;

/*
    Создать буффер на 64кБ и вычитывать данные в него
 */
public class RemoveZero {
    public static void main(String[] args) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new ByteArrayInputStream(new byte[]{0,78,67,0,89,85,0,0,72,82,85,77,0});
//            inputStream = new FileInputStream("e:/a.txt");
            outputStream = new FileOutputStream("e:/b.txt");
//            ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
            long startTime = System.currentTimeMillis();
            copyWithoutZeroes(inputStream, outputStream);
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
//            System.out.println(elapsedTime);
//            System.out.println(Arrays.toString(outputStream1.toByteArray()));
        } catch (IOException e) {
            // NOP
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

    private static void copyWithoutZeroes(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] buff = new byte[64 * 1024];
        int count;
        while ((count = inputStream.read(buff)) != -1) {
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

                outputStream.write(buff, startIndexOfCopiedSegment, segmentLength+1);
                outputStream.flush();

                index++;
            }
        }
        outputStream.flush();
    }
}
