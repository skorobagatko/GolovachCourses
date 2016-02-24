package procedural;

import java.util.Arrays;

/**
 * Created by Stanislav on 30.01.2016.
 */
public class ArraySorting {
    public static void main(String[] args) {

        int[] arr = {4, 2, 20, 10, 0, 7, 3, 9, 40, 15, 30};

        // Bubble sorting
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        System.out.println("Bubble sorting - \t\t\t\t" + Arrays.toString(arr));

        // Bubble reverse order sorting
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] > arr[j-1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
        System.out.println("Bubble reverse order sorting - \t" + Arrays.toString(arr));

        // Select sorting
        int[] arr2 = {7, 3, 2, 0, 5, 8, 4, 6, 9, 1};

        for (int i = 0; i < arr2.length - 1; i++) {
            int min = arr2[i];  // minimal number
            int index = i;      // value of minimal number
            for (int j = i+1; j < arr2.length; j++) {
                if (arr2[j] < min) {
                    min = arr2[j];
                    index = j;
                }
            }
            int tmp = arr2[i];
            arr2[i] = min;
            arr2[index] = tmp;
        }
        System.out.println("Select sort - \t\t\t\t\t" + Arrays.toString(arr2));

        // Insert-sort
        int[] arr3 = {7, 3, 2, 0, 5, 8, 4, 6, 9, 1};

        for (int i = 1; i < arr3.length; i++) {
            for (int j = i; j > 0 && arr3[j] < arr3[j-1]; j--) {
                int tmp = arr3[j];
                arr3[j] = arr3[j-1];
                arr3[j-1] = tmp;
            }
        }
        System.out.println("Insert-sort - \t\t\t\t\t" + Arrays.toString(arr3));

        // Merge two sorted arrays
        int[] a = {0, 2, 4, 6, 8, 9};
        int[] b = {1, 3, 5, 7};
        int[] result = new int[a.length + b.length];

        int aIndex = 0;
        int bIndex = 0;

        while (aIndex + bIndex != result.length) {
            if (aIndex < a.length && bIndex < b.length) {
                if (a[aIndex] < b[bIndex]) {
                    result[aIndex + bIndex] = a[aIndex++];
                } else {
                    result[aIndex + bIndex] = b[bIndex++];
                }
            } else if (aIndex >= a.length) {
                result[aIndex + bIndex] = b[bIndex++];
            } else if (bIndex >= b.length) {
                result[aIndex + bIndex] = a[aIndex++];
            }
        }
        System.out.println("Merge two sorted arrays - \t\t" + Arrays.toString(result));
    }

}
