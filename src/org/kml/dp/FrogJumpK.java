package org.kml.dp;

import java.util.Arrays;

public class FrogJumpK {
    public int frogJump(int[] heights, int k) {
        //return frogJumpRec(heights, k, heights.length - 1);
        //return frogJumpTab(heights, k, heights.length - 1);
        return frogJumpTabSpace(heights, k, heights.length - 1);
    }

    public int frogJumpTabSpace(int[] heights, int k, int n)
    {
        int[] cache = new int[k];
        cache[0] = 0;
        for(int idx = 1; idx < k; idx++)
        {
            int minEffrot = Integer.MAX_VALUE;
            for (int jump = 1; jump <= k && idx - jump >= 0; jump++) {
                int effrot = Math.abs(heights[idx] - heights[idx - jump]) + cache[idx - jump];
                minEffrot = Math.min(minEffrot, effrot);
            }
            cache[idx] = minEffrot;
        }

        for(int idx = k ; idx <= n; idx++)
        {
            int minEffrot = Integer.MAX_VALUE;
            for (int jump = 1; jump <= k && idx - jump >= 0 ; jump++) {
                int effort = Math.abs(heights[idx] - heights[idx - jump])
                        + cache[k - jump];
                minEffrot = Math.min(minEffrot, effort);
            }
            for(int i = 0; i < k - 1; i++)
            {
                cache[i] = cache[i + 1];
            }
            cache[k - 1] = minEffrot;
        }
        return cache[cache.length - 1];
    }
    public int frogJumpTab(int[] heights, int k, int n)
    {
        int[] cache = new int[n + 1];
        cache[0] = 0;
        for(int idx = 1; idx <= n; idx++)
        {
            int minEffrot = Integer.MAX_VALUE;
            for (int jump = 1; jump <= k && idx - jump >= 0; jump++)
            {
                int effrot = Math.abs(heights[idx] - heights[idx - jump]) + cache[idx - jump];
                minEffrot = Math.min(minEffrot, effrot);
            }
            cache[idx] = minEffrot;
        }
        return cache[cache.length - 1];
    }
    public int frogJumpRec(int[] heights, int k, int n)
    {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        return frogJumpRec(heights, k, n, cache);
    }
    public int frogJumpRec(int[] heights, int k, int n, int[] cache) {
        if (n == 0) return 0;
        if(cache[n] != -1) return cache[n];
        int minEffrot = Integer.MAX_VALUE;
        for (int jump = 1; jump <= k && jump <= n; jump++) {
            int effrot = Math.abs(heights[n] - heights[n - jump])
                    + frogJumpRec(heights, k, n - jump, cache);
            minEffrot = Math.min(minEffrot, effrot);
        }
        return cache[n] = minEffrot;
    }

    public static void main(String[] args) {
        //int[] heights = {15, 4, 1, 14, 15};
        //int k = 3;
        int[] heights = {10, 5, 20, 0, 15};
        int k = 2;
        // Create an instance of Solution class
        FrogJumpK sol = new FrogJumpK();

        // Print the answer
        System.out.println("Minimum energy: " + sol.frogJump(heights, k));

    }
}