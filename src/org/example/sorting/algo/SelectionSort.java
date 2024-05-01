package org.example.sorting.algo;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {13,46,24,52,20,9};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * @param arr
     *
     * TC - O(n^2)
     * SC - O(1)
     */
    private static void sort(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex])
                {
                    minIndex = j;
                }
            }
            // swap minIndex with start
            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }
    }
}
