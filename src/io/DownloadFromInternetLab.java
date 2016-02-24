package io;

import java.io.*;
import java.net.URL;

/*
    Задача - Программа скачивает страницу из интернета и сохраняет
    ее в два файла с расширением html
    Сделать буфферизацию всех потоков на 64кБ
    Обработать все ошибки - гарантированно закрыть все потоки.
    Если было выброшено исключение - удалить два файла с данными
    Т.е. мы либо сохраняем данные если все хорошо, либо удаляем файлы,
    если было какое-то исключение, т.к. смысла оставлять недозаписаннные файлы нет.
    Метод flush() вызвать только в том случае, если все прошло удачно.
 */
public class DownloadFromInternetLab {
    public static void main(String[] args) {
        File tmp1 = new File("e:/tmp1.html");
        File tmp2 = new File("e:/tmp2.html");
        InputStream inputStream = null;
        OutputStream outputStream1 = null;
        OutputStream outputStream2 = null;
        try {
            inputStream = new BufferedInputStream(new URL("http://lenta.ru/").openStream(), 64 * 1024);
            outputStream1 = new BufferedOutputStream(new FileOutputStream(tmp1), 64 * 1024);
            outputStream2 = new BufferedOutputStream(new FileOutputStream(tmp2), 64 * 1024);
            byte[] buff = new byte[256];
            int count;
            while ((count = inputStream.read(buff)) != -1) {
                outputStream1.write(buff, 0, count);
                outputStream2.write(buff, 0, count);
            }
            outputStream1.flush();
            outputStream2.flush();
        } catch (IOException e) {
            tmp1.delete();
            tmp2.delete();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                    if (outputStream1 != null) {
                        try {
                            outputStream1.close();
                            if (outputStream2 != null) {
                                try {
                                    outputStream2.close();
                                } catch (IOException e) {
                                    // NOP
                                }
                            }
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
}
