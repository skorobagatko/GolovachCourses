package collections;

import static collections.IteratorUtils.*;

public class Test {
    public static void main(String[] args) {

        int[] arr = {0,1,2,3,4,5,6,7,8,9,10,11,12};

        for (Integer i : interval(4, arr.length)) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        for (int i : squares(0, arr.length)) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i : merge(interval(0,10), interval(5,15))) {
            System.out.print(i + " ");
        }
    }
}
