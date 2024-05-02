package org.kml.arrays;

import java.util.Arrays;

public class LeftRotateArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(arr) + " --- " + Arrays.toString(leftRotateArray(arr, 2)));
        System.out.println(Arrays.toString(arr) + " --- " + Arrays.toString(leftRotateArray(arr, 0)));
        System.out.println(Arrays.toString(arr) + " --- " + Arrays.toString(leftRotateArray(arr, 1)));
    }
    private static int[] leftRotateArray(int[] arr, int d)
    {
        d = d % arr.length;
        int[] tmp = new int[d];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = arr[i];
        }
        for (int i = d; i < arr.length; i++) {
            arr[i - d] = arr[i];
        }
        for (int i = 0; i < tmp.length; i++) {
            arr[arr.length - d + i] = tmp[i];
        }
        return arr;
    }
}
