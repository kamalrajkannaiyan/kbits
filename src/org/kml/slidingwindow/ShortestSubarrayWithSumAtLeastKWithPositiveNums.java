package org.kml.slidingwindow;

public class ShortestSubarrayWithSumAtLeastKWithPositiveNums {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int k = 7;
        System.out.println(shortestSubarrayWithSumAtLeastK(nums, k)); // Output: 2 (Subarray: [4, 3])
    }
    private static int shortestSubarrayWithSumAtLeastK(int[] nums, int k)
    {
        int len = Integer.MAX_VALUE, sum = 0, left = 0;
        for (int right = 0; right < nums.length; right++)
        {
            sum += nums[right];
            while (sum >=k)
            {
                len = Math.min(len, right - left + 1);
                sum -= nums[left++];
            }
        }
        return len;
    }
}
