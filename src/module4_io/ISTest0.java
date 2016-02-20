package module4_io;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ISTest0 {
    public static void main(String[] args) {
        InputStream urlStream = null;
        try {
            urlStream = new URL("http://google.com/").openStream();
            readByByte(urlStream);
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
        }
    }

    private static void readByByte(InputStream inputStream) throws IOException {
        int readedByte;
        while ((readedByte = inputStream.read()) != -1) {
            System.out.print((char) readedByte);
        }
    }
}
