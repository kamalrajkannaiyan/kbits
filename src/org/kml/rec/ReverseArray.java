package org.kml.rec;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(arr));
        reverse(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    private static void reverse(int[] arr, int start, int end)
    {
        if(start < end)
        {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            reverse(arr, start + 1, end - 1);
        }
    }
}
