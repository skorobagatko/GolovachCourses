package io;

import java.io.*;
import java.net.URL;

public class ISOSTest0 {
    public static void main(String[] args) {
        InputStream urlStream = null;
        OutputStream fileStream = null;
        try {
            urlStream = new BufferedInputStream(new URL("http://google.com/").openStream(), 128);
            fileStream = new BufferedOutputStream(new FileOutputStream("e:/a.html"));
            readAndWrite(urlStream, fileStream);
            fileStream.flush();
        } catch (IOException e) {
            // NOP
        } finally {
            if (urlStream != null) {
                try {
                    urlStream.close();
                } catch (IOException e) {
                    // NOP
                }
            }
            if (fileStream != null) {
                try {
                    fileStream.close();
                } catch (IOException e) {
                    // NOP
                }
            }
        }
    }

    private static void readAndWrite(InputStream inputStream, OutputStream outputStream) throws IOException {
        int readedByte;
        while ((readedByte = inputStream.read()) != -1) {
            outputStream.write(readedByte);
        }
    }
}
