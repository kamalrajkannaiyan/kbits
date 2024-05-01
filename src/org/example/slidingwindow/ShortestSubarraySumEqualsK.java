package org.example.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShortestSubarraySumEqualsK {
    public static void main(String[] args) {
        //int[] nums = {2, 7, 3, -8, 2, 10};
        int[] nums = {1, -1, 5, -2, 3};
        System.out.println(Arrays.toString(nums));
        int len = shortestSubArray(nums, 3);
        System.out.println(len);
    }
    private static int shortestSubArray(int[] nums, int k)
    {
        int len = Integer.MAX_VALUE, sum = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, -1);
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            if (prefixSumMap.containsKey(sum - k))
            {
                len = Math.min(len, i - prefixSumMap.get(sum - k));
            }

            prefixSumMap.put(sum, i);
        }
        System.out.println(prefixSumMap);
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
