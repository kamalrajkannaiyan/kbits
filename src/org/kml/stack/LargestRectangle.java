package org.kml.stack;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangle {
    static int largestRectangle(int[] heights) {
        int maxArea = 0;
        int[] pse = findPSE(heights);
        int[] nse = findNSE(heights);
        System.out.println("PSE " + Arrays.toString(pse));
        System.out.println("NSE " + Arrays.toString(nse));
        for (int idx = 0; idx < heights.length; idx++) {
            int area = heights[idx] * (nse[idx] - pse[idx] - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private static int[] findPSE(int[] heights) {
        int[] pse = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for (int idx = 0; idx < heights.length; idx++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[idx]) {
                stack.pop();
            }
            pse[idx] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(idx);
        }
        return pse;
    }

    private static int[] findNSE(int[] heights) {
        int[] nse = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for (int idx = heights.length - 1; idx >= 0; idx--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[idx]) {
                stack.pop();
            }
            nse[idx] = (stack.isEmpty()) ? heights.length : stack.peek();
            stack.push(idx);
        }
        return nse;
    }

    static int largestRectablgeNaive(int[] heights) {
        int maxArea = 0;
        for (int idx = 0; idx < heights.length; idx++) {
            int area = heights[idx];
            for (int leftIdx = idx - 1; leftIdx >= 0; leftIdx--) {
                if (heights[leftIdx] < heights[idx]) {
                    break;
                }
                area += heights[idx];
            }
            for (int rightIdx = idx + 1; rightIdx < heights.length; rightIdx++) {
                if (heights[rightIdx] < heights[idx]) {
                    break;
                }
                area += heights[idx];
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        //heights = new int[]{3, 5, 1, 7, 5, 9};
        //heights = new int[]{2, 4};
        int largestRec = largestRectablgeNaive(heights);
        System.out.println(Arrays.toString(heights) + " largest rectable area " + largestRec);
        System.out.println(Arrays.toString(heights) + " largest rectable area " + largestRectangle(heights));
    }
}
