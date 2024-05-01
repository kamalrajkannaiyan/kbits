package org.example.slidingwindow;

public class ShortestSubarraySumEqualsKWithPositiveNums {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 9;
        System.out.println(shortestSubarraySumEqualsK(nums, k)); // Output: 2 (Subarray: [4,5])
    }
    private static int shortestSubarraySumEqualsK(int[] nums, int k)
    {
        int len = Integer.MAX_VALUE, sum = 0, left = 0;
        for (int right = 0; right < nums.length; right++)
        {
            sum += nums[right];
            while (sum > k)
            {
                sum -= nums[left++];
            }
            if(sum == k)
            {
                len = Math.min(len, right - left + 1);
            }
        }
        return len;
    }
}
