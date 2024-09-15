package org.kml.sorting.algo;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {13,46,24,52,20,9};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * TC - O(n^2)
     * SC - O(1)
     */
    private static void sort(int[] arr)
    {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--)
            {
                if(arr[j - 1] > arr[j])
                {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
                else
                {
                    break;
                }
            }
        }
    }
}
