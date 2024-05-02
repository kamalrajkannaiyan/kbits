package org.kml.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,3,4,4,5,7,7,7,7,};
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(union(arr1, arr2));
    }

    private static List<Integer> union(int[] arr1, int[] arr2)
    {
        List<Integer> union = new ArrayList<>();
        int arr1Index = 0, arr2Index = 0;
        while (arr1Index < arr1.length && arr2Index < arr2.length)
        {
            if (arr1[arr1Index] <= arr2[arr2Index])
            {
                if(union.isEmpty() || union.get(union.size() - 1) != arr1[arr1Index])
                {
                    union.add(arr1[arr1Index]);
                }
                arr1Index++;
            }
            else
            {
                if(union.isEmpty() || union.get(union.size() - 1) != arr2[arr2Index])
                {
                    union.add(arr2[arr2Index]);
                }
                arr2Index++;
            }
        }
        while (arr1Index < arr1.length)
        {
            if(union.isEmpty() || union.get(union.size() - 1) != arr1[arr1Index])
            {
                union.add(arr1[arr1Index]);
            }
            arr1Index++;
        }
        while (arr2Index < arr2.length)
        {
            if(union.isEmpty() || union.get(union.size() - 1) != arr2[arr2Index])
            {
                union.add(arr2[arr2Index]);
            }
            arr2Index++;
        }
        return union;
    }
}
