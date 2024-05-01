package org.example.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestSubarrayWithSumAtMostK {
    public static int longestSubarrayWithSumAtMostK(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int maxLength = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            // make sure window meets the constraint
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] > k) {
                deque.pollFirst();
            }
            // find the ans in the valid window
            if (!deque.isEmpty()) {
                maxLength = Math.max(maxLength, i - deque.peekFirst());
            }
            // build monotonically increasing queue
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        System.out.println(longestSubarrayWithSumAtMostK(nums, k)); // Output: 4 (Subarray: [1, -1, 5, -2])
    }
}
