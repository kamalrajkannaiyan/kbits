package org.kml.arrays.subarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateAllSubArrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println("Iterative way---");
        List<int[]> iterList = generateAllSubArrays(arr);
        for (int[] subArray: iterList) {
            System.out.println(Arrays.toString(subArray));
        }
        System.out.println("Recursive way---");
        List<int[]> recList =generateAllSubArrays(arr, 0);
        for (int[] subArray: recList) {
            System.out.println(Arrays.toString(subArray));
        }

        System.out.println("###########################");
    }

    private static List<int[]> generateAllSubArrays(int[] arr)
    {
        List<int[]> subArrays = new ArrayList<>();
        for (int start = 0; start < arr.length; start++)
        {
            for(int saEnd = start; saEnd < arr.length; saEnd++)
            {
                subArrays.add(Arrays.copyOfRange(arr, start, saEnd + 1));
            }
        }
        return subArrays;
    }
    private static List<int[]> generateAllSubArrays(int[] arr, int start)
    {
        List<int[]> subArrays = new ArrayList<>();
        if(start == arr.length) return subArrays;
        for(int saEnd = start; saEnd < arr.length; saEnd++)
        {
            subArrays.add(Arrays.copyOfRange(arr, start, saEnd + 1));
        }
        subArrays.addAll(generateAllSubArrays(arr, start + 1));
        return subArrays;
    }
}
