package module4_io;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ISOSTest1 {
    public static void main(String[] args) {
        InputStream urlStream = null;
        OutputStream fileStream = null;
        try {
            urlStream = new BufferedInputStream(new URL("http://google.com/").openStream(), 128);
            byte[] data = readByArray(urlStream);
            System.out.println(new String(data, "UTF-8"));
        } catch (IOException e) {
            // NOP
        }
    }

    private static byte[] readByArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buff = new byte[256];
        int count;
        while ((count = inputStream.read(buff)) != -1) {
            out.write(buff, 0, count);
        }
        return out.toByteArray();
    }
}
