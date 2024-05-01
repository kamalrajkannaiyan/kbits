package org.kml.arrays;

public class MergeIndividualSortedArray {
    private static int[] merge(int[] arr1, int[] arr2)
    {
        int[] mergedArr = new int[arr1.length + arr2.length];
        int arr1Index = 0, arr2Index = 0, mergeIndex = 0;
        while (arr1Index < arr1.length && arr2Index < arr2.length)
        {
            if(arr1[arr1Index] < arr2[arr2Index])
            {
                mergedArr[mergeIndex] = arr1[arr1Index];
                arr1Index++;
            }
            else
            {
                mergedArr[mergeIndex] = arr2[arr2Index];
                arr2Index++;
            }
            mergeIndex++;
        }
        while (arr1Index < arr1.length)
        {
            mergedArr[mergeIndex] = arr1[arr1Index];
            arr1Index++;
            mergeIndex++;
        }
        while (arr2Index < arr2.length)
        {
            mergedArr[mergeIndex] = arr2[arr2Index];
            arr2Index++;
            mergeIndex++;
        }
        return mergedArr;
    }
}
