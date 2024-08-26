package org.kml.binarysearch;

import java.util.Arrays;

public class MinimizeLargestSum {
    public static void main(String[] args) {
        int[] arr1 = {1,1,10};
        int[] arr = {10, 20, 30, 40};
        System.out.println(splitArray(arr1, 3));
    }
    public static int countPartitions(int []arr,int lim) {
        System.out.println("Evaluating for limit - " + lim + " on arr " + Arrays.toString(arr));
        int subArrCount = 1;
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (sum + arr[i] > lim)
            {
                System.out.println("Mark --- " + (i - 1));
                subArrCount++;
                sum = arr[i];
            }
            else
            {
                sum += arr[i];
            }
        }
        System.out.println("No of sub arrays - " + subArrCount);
        return subArrCount;
    }
    public static int splitArray(int[] nums, int k) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();

        for (int maxSum = low; maxSum <= high; maxSum++) {
            if (countPartitions(nums, maxSum) == k)
                return maxSum;
        }
        /*
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (countsub(nums, mid) > k) low = mid + 1;
            else high = mid - 1;
        }
        return low;
        */
        return -1;
    }
}