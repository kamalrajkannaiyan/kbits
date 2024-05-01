package org.kml.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {2, 7, 3, -8, 2, 10}; int k = 2;
        //int[] nums = {1, -1, 5, -2, 3};
        //int[] nums = {0,0,0,0,1,1,0}; int k = 1;
        System.out.println(Arrays.toString(nums));
        int len = longestSubArray(nums, k);
        System.out.println(len);
    }
    private static int longestSubArray(int[] nums, int k)
    {
        int len = Integer.MIN_VALUE, sum = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, -1);
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            if (prefixSumMap.containsKey(sum - k))
            {
                len = Math.max(len, i - prefixSumMap.get(sum - k));
            }

            prefixSumMap.putIfAbsent(sum, i);
        }
        System.out.println(prefixSumMap);
        return len == Integer.MIN_VALUE ? 0 : len;
    }
}
