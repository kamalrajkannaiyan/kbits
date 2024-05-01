package org.kml.slidingwindow;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ShortestSubarrayWithSumAtLeastK {
    public static int shortestSubarrayWithSumAtLeastK(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int minLength = Integer.MAX_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            //find the solution in the valid window
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - deque.pollFirst());
            }
            // build monotincally increasing queue
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {
        //int[] nums = {1, 2, 3, 4, 5}; // k = 11;
        int[] nums = {2, 7, 3, -8, 4, 10};
        int k = 12;
        System.out.println(Arrays.toString(nums));
        System.out.println(shortestSubarrayWithSumAtLeastK(nums, k)); // Output: 3 (Subarray: [3, 4, 5])
    }
}
