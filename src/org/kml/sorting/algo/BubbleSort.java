package org.kml.sorting.algo;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {13,46,24,52,20,9};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * TC - O(n^2)
     * SC - O(1)
     */
    private static void sort(int[] arr)
    {
        for (int i = arr.length - 1; i >= 0; i--)
        {
            boolean didSwap = false;
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j + 1])
                {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                    didSwap = true;
                }
            }
            if (!didSwap) return;
        }
    }
}
