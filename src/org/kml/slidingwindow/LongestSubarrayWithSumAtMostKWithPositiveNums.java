package org.kml.slidingwindow;

public class LongestSubarrayWithSumAtMostKWithPositiveNums {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 9;
        System.out.println(longestSubarrayWithSumAtMostK(nums, k)); // Output: 3 (Subarray: [2, 3, 4])
    }
    private static int longestSubarrayWithSumAtMostK(int[] nums, int k)
    {
        int len = 0, sum = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while(sum > k)
            {
                sum -= nums[left++];
            }
            len = Math.max(len, right - left + 1);
        }
        return len;
    }
}
