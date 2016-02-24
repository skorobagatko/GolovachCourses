package io;

import java.io.*;

public class ISOSTimeTest {
    public static void main(String[] args) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("e:/IMG_4140.JPG");
            outputStream = new FileOutputStream("e:/IMG_4140_1.JPG");
            long startTime = System.currentTimeMillis();
            copy(inputStream, outputStream);
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(elapsedTime);
        } catch (IOException e) {
            // NOP
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // NOP
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    // NOP
                }
            }
        }
    }

    private static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] buff = new byte[128 * 1024];
        int count;
        while ((count = inputStream.read(buff)) != -1) {
            outputStream.write(buff, 0, count);
        }
    }
}
