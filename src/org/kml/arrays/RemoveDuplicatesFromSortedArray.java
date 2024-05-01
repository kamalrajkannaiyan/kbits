package org.kml.arrays;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] arr1 = {1,1,2,2,2,3,3};
        System.out.println(Arrays.toString(arr1) + " -> " + removeDuplicates(arr1));
        int[] arr2 = {1,1,1,2,2,3,3,3,3,4,4};
        System.out.println(Arrays.toString(arr2) + " -> " + removeDuplicates(arr2));
        int[] arr3 = {1,2,3};
        System.out.println(Arrays.toString(arr3) + " -> " + removeDuplicates(arr3));

    }
    private static int removeDuplicates(int[] arr)
    {
        int uniqueIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[uniqueIndex] != arr[i])
            {
                uniqueIndex++;
                arr[uniqueIndex] = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr));
        return uniqueIndex + 1;
    }
}
