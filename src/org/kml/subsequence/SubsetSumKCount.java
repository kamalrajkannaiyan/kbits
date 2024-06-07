package org.kml.subsequence;

import java.util.Arrays;

public class SubsetSumKCount {
    public static void main(String[] args) {
        //int[] nums = {1,2,2,3};
        int[] nums = {0,0,1};
        int K = 1;
        System.out.println(Arrays.toString(nums));
        int count = countSubsetSumEqualsK(nums, K);
        System.out.println(count);
    }
    static int countSubsetSumEqualsK(int[] nums, int K)
    {
        int[][] dp = new int[nums.length][K+1];
        for(int[] row: dp)
        {
            Arrays.fill(row, -1);
        }
        return countSubsetSumEqualsK(nums, K, nums.length - 1, dp);
    }
    static int countSubsetSumEqualsK(int[] nums, int K, int ind, int[][] dp)
    {
        if (K == 0) return 1;
        if (ind < 0) return 0;

        if (dp[ind][K] != -1) return dp[ind][K];
        int nonPickCount = countSubsetSumEqualsK(nums, K, ind - 1, dp);
        int pickCount = 0;
        if(nums[ind] <= K)
        {
            pickCount = countSubsetSumEqualsK(nums, K - nums[ind], ind - 1, dp);
        }
        return dp[ind][K] = nonPickCount + pickCount;
    }
}
