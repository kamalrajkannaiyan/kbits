package org.kml.sorting.algo;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {13,46,24,52,20,9};
        //int[] arr = {2,1};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void sort(int[] arr)
    {
        sort(arr, 0, arr.length);
    }
    private static void sort(int[] arr, int low, int high)
    {
        if(high <= low) return;
        int pivot = partition(arr, low, high);
        sort(arr, low, pivot);
        sort(arr, pivot + 1, high);
    }

    private static int partition(int[] arr, int low, int high)
    {
        int pivotVal = arr[low];
        int start = low;
        int end = high;

        while (start < end) {
            while (arr[start] <= pivotVal && start <= high - 1) {
                start++;
            }
            while (arr[end] > pivotVal && end >= low + 1) {
                end--;
            }
            if (start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[end];
        arr[end] = temp;
        return end;
    }
}
