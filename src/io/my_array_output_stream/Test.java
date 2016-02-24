package io.my_array_output_stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws IOException {
        byte[] arr = new byte[] {1,2,3,4};
        byte[] arr1 = new byte[] {0,0,0,5,6,7,0,0};
        byte[] arr2 = new byte[] {8,9,10,11,12};

        ArrayOutputStream os = new ArrayOutputStream();
        for (byte b : arr) {
            os.write(b);
        }
        os.write(arr1, 3, 3);
        os.write(arr2);

        System.out.println(Arrays.toString(os.toByteArray()));
        os.writeTo(new FileOutputStream("e:/b.txt"));
    }
}
