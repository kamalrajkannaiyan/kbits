package org.kml.stack;

import java.util.Arrays;
import java.util.Stack;

public class NGECircularArray {
    public static int[] nextGreaterElements(int[] arr) {
        int MOD = arr.length;
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack();
        for(int idx = 2*arr.length - 1; idx >= 0; idx--){
            while(!stack.isEmpty() && stack.peek() <= arr[idx % MOD]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[idx%MOD] = -1;
            }else{
                result[idx%MOD] = stack.peek();
            }
            stack.push(arr[idx%MOD]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 1, 7, 6, 0};
        int[] nge = nextGreaterElements(nums);
        System.out.println(Arrays.toString(nge));
    }
}
