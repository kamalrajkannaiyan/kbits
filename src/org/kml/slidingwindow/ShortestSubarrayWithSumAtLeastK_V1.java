package org.kml.slidingwindow;

import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubarrayWithSumAtLeastK_V1
{
    public static void main(String[] args) {
        int[] nums = {2, 7, 3, -8, 4, 10};
        int len = shortestSubArray(nums, 12);
        System.out.println(len);
    }
    public static int shortestSubArray(int[] nums, int target)
    {
        int sum = 0, len = Integer.MAX_VALUE;
        Deque<Pair> dq = new LinkedList<>();

        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];

            // Calculate your answer here
            if(sum >= target) len = Math.min(len, i + 1);

            // Keep dq in incrementing order
            while(!dq.isEmpty() && sum <= dq.peekLast().value)
            {
                dq.removeLast();
            }

            // Add current sum and index
            dq.add(new Pair(i,sum));

            // Check if Contraction is possible or not
            while(!dq.isEmpty() && sum - dq.peekFirst().value >= target)
            {
                len = Math.min(len, i - dq.peekFirst().index);
                dq.removeFirst();
            }
        }
        return (len == Integer.MAX_VALUE) ? -1 : len;
    }
}
class Pair
{
    int index;
    long value;
    Pair(int index, long value)
    {
        this.index = index;
        this.value = value;
    }
}