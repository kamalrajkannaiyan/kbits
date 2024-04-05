package org.example.slidingwindow;

public class LongestWindowSumK {
    public static void main(String[] args) {
        int[] arr = {10,2,3,5,1,1,1,1,1,1};
        System.out.println(longestWindow(arr, 10));
    }

    private static int longestWindow(int[] nums, int target)
    {
        int maxLen = 0, left = 0, sum = 0;
        for (int right = 0; right < nums.length; right++)
        {
            // update the window
            sum += nums[right];

            // check where window violates the constraint
            while (sum > target)
            {
                sum -= nums[left++];
            }

            if (sum == target)
            {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen;
    }
}
