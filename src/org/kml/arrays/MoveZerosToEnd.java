package org.kml.arrays;

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] nums = {1 ,0 ,2 ,3 ,0 ,4 ,0 ,1};
        System.out.println(Arrays.toString(nums));
        moveZeroToEnd(nums);
        System.out.println(Arrays.toString(nums));
    }
    private static void moveZeroToEnd(int[] nums)
    {
        int currIndex = 0, sortedIndex = 0;
        for (currIndex = 0; currIndex < nums.length; currIndex++)
        {
            if(nums[currIndex]!=0)
            {
                nums[sortedIndex++] = nums[currIndex];
            }
        }
        while (sortedIndex < nums.length)
        {
            nums[sortedIndex++] = 0;
        }
    }
}
