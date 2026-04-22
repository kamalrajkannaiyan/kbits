package org.kml.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElements {

    public static int[] nextGreaterElements(int[] arr) {
        int[] nge = new int[arr.length];
        ArrayDeque<Integer> minStack = new ArrayDeque<>();
        for (int idx = arr.length - 1; idx >= 0; idx--) {
            while (!minStack.isEmpty() && minStack.peek() <= arr[idx]) {
                minStack.pop();
            }
            if (minStack.isEmpty()) {
                nge[idx] = -1;
            } else {
                nge[idx] = minStack.peek();
            }
            minStack.push(arr[idx]);
        }
        return nge;
    }

    private static int[] findPreviousGreaterElement(int[] height) {
        int[] pge = new int[height.length];
        Stack<Integer> minStack = new Stack<>();
        for (int idx = 0; idx < height.length; idx++) {
            while (!minStack.isEmpty() && minStack.peek() <= height[idx]) {
                minStack.pop();
            }
            if (minStack.isEmpty()) {
                pge[idx] = -1;
            } else {
                pge[idx] = minStack.peek();
            }
            minStack.push(height[idx]);
        }
        return pge;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 2};
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] nge = nextGreaterElements(nums);
        int[] pge = findPreviousGreaterElement(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nge));
        System.out.println(Arrays.toString(pge));

        int total = 0;
        int[] trapped = new int[nums.length];
        for (int idx = 0; idx < nums.length; idx++) {
            int trappedWater = Math.min(nge[idx], pge[idx]) - nums[idx];
            //System.out.println(nums[idx] + "--"+ nge[idx] + "--"+pge[idx] + "--"+trappedWater);
            if (trappedWater > 0) {
                total += trappedWater;
                trapped[idx] = trappedWater;
            }

        }
        System.out.println(Arrays.toString(trapped));

        System.out.println(total);
    }

}
