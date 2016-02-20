package module5_collections;

import java.util.Arrays;

public class GenericHolderTest {
    public static void main(String[] args) {
        GenericHolder<int[]> holder = new GenericHolder<>();
        int[] arr = {1,2,3};
        holder.setData(arr);
        System.out.println(Arrays.toString(holder.getData()));
    }
}
