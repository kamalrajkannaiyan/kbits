package org.kml.sorting.algo;

import java.util.Arrays;

public class CountSort {
    private static void countSort(int[] nums)
    {
        int range = -1;
        for (int num:nums)
        {
            range = Math.max(range, num);
        }

        int counts[] = new int[range + 1];
        int tmp[] = new int[nums.length];
        for (int num: nums)
        {
            counts[num]++;
        }
        System.out.println("counte array " + Arrays.toString(counts));
        for (int idx = 1; idx < counts.length; idx++)
        {
            counts[idx] = counts[idx] + counts[idx - 1];
        }
        System.out.println("counte array " + Arrays.toString(counts));

        for(int idx = nums.length - 1; idx >= 0; idx--)
        {
            int data = nums[idx];
            int tagetIdx = --counts[data];
            tmp[tagetIdx] = data;
        }
        System.out.println("Sorted Tmp " + Arrays.toString(tmp));
        for (int idx = 0; idx < nums.length; idx++) {
            nums[idx] = tmp[idx];
        }
    }
    public static void main(String[] args) {
        int nums[] = {2, 1, 1, 0, 2, 5, 4, 0, 2, 8, 7, 7, 9, 2, 0, 1, 9};
        System.out.println(Arrays.toString(nums));
        countSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
