package org.kml.prefixsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,0,0};
        System.out.println(Arrays.toString(nums) + " --> "+countSubArraySumEqualsK(nums, 3));
    }

    private static int countSubArraySumEqualsK(int[] nums, int K)
    {
        int count = 0, sum = 0;
        Map<Integer, Integer> sumfreqMap = new HashMap<>();
        sumfreqMap.put(0, 1);
        for (int num: nums)
        {
            sum += num;
            if(sumfreqMap.containsKey(sum - K))
            {
                count += sumfreqMap.get(sum - K);
            }
            sumfreqMap.put(sum,sumfreqMap.getOrDefault(sum,0) + 1);
        }
        return count;
    }
}
