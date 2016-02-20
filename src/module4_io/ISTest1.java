package module4_io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

public class ISTest1 {
    public static void main(String[] args) {
        InputStream urlStream = null;
        try {
            urlStream = new URL("http://google.com/").openStream();
            readByArray(urlStream);
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

    private static void readByArray(InputStream is) throws IOException {
        byte[] buff = new byte[128];
        int count;
        while ((count = is.read(buff)) != -1) {
            System.out.print(new String(buff, 0, count, "UTF-8"));
        }
    }
}
