package org.kml.slidingwindow;

public class MaxSumSubArraySizeK
{
    public static void main(String[] args) {
        int[] arr = {10,20,30,40};
        System.out.println(maxSumSubArraySizeK(arr, 2));
    }

    private static int maxSumSubArraySizeK(int[] nums, int k)
    {
        int maxSum = 0, sum = 0;
        // build first window solution
        for(int i = 0; i < k; i++)
        {
            sum += nums[i];
        }
        maxSum = sum;

        //build solutions from next windows
        for (int i = k; i < nums.length; i++)
        {
            sum = sum - nums[i - k];
            sum = sum + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
