package org.kml.numbers.extra;

import java.util.Arrays;

public class MissingNumber
{
    public static void main(String[] args) {
        int[] nums = {1,2,4,5};
        System.out.println(Arrays.toString(nums) + " Missing Number " + findMissingNumber(nums));
    }
    private static int findMissingNumber(int[] nums)
    {
        int xor = 0;
        for(int num:nums)
        {
            xor ^= num;
        }
        // range is between 1 - N; given array has elements (1 - (N - 1))
        for (int i = 1; i <= nums.length + 1; i++)
        {
            xor ^= i ;
        }
        return xor;
    }
}
