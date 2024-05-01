package org.kml.sorting.algo;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println(sc.nextInt());
        int[] arr = {13,46,24,52,20,9};
        //int[] arr = {2,1};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * TC - O(nlogn)
     * SC - O(n)
     * @param arr
     */
    private static void sort(int[] arr)
    {
        sort(arr, 0, arr.length - 1);
    }
    private static void sort(int[] arr, int low, int high)
    {
        if(high <= low) return;
        int mid = low + (high - low) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }
    private static void merge(int[] arr, int low, int mid, int high)
    {
        //if(high <= low) return;
        int[] tmp = new int[high - low + 1];
        int left = low, right = mid + 1, tmpIdx = 0;

        while (left <= mid && right <= high)
        {
            if(arr[left] < arr[right])
            {
                tmp[tmpIdx] = arr[left++];
            }
            else
            {
                tmp[tmpIdx] = arr[right++];
            }
            tmpIdx++;
        }

        while (left <= mid)
        {
            tmp[tmpIdx++] = arr[left++];
        }
        while (right <= high)
        {
            tmp[tmpIdx++] = arr[right++];
        }

        for (int i = 0; i < tmp.length; i++) {
            arr[low + i] = tmp[i];
        }
    }
}
