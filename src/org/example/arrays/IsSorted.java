package org.example.arrays;

import java.util.Arrays;

public class IsSorted {
    public static void main(String[] args) {
        int[] asc = {1,2,3,4,5};
        System.out.println(Arrays.toString(asc) + " --> " +isSorted(asc));
        int[] asc1 = {1,2,3,4,5,3};
        System.out.println(Arrays.toString(asc1) + " --> " +isSorted(asc1));
        int[] desc = {5,4,3,2,1};
        System.out.println(Arrays.toString(desc) + " --> " +isSorted(desc));
        int[] desc1 = {5,4,2,3,1};
        System.out.println(Arrays.toString(desc1) + " --> " +isSorted(desc1));
        int[] equal = {1,1,1,1};
        System.out.println(Arrays.toString(equal) + " --> " +isSorted(equal));
        int[] equal1 = {1,1,2,1,1};
        System.out.println(Arrays.toString(equal1) + " --> " +isSorted(equal1));
    }

    private static boolean isSorted(int[] arr)
    {
        boolean equal = false, asc = false;
        if(arr[0] == arr[arr.length - 1])
        {
            equal = true;
        } else if (arr[0] < arr[arr.length - 1]) {
            asc = true;
        }
        for (int i = 1; i < arr.length; i++) {
            if (equal)
            {
                if(arr[i -1] != arr[i]) return false;
            } else if (asc) {
                if(arr[i - 1] > arr[i]) return false;
            }
            else {
                if (arr[i - 1] < arr[i]) return false;
            }
        }
        return true;
    }
}
