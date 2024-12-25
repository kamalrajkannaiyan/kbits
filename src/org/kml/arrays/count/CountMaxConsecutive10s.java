package org.kml.arrays.count;

public class CountMaxConsecutive10s
{
    private static int maxCount(int[] nums)
    {
        int last = nums[0];
        int max = 1, count = 1;
        for (int idx = 1; idx < nums.length; idx++)
        {
            if(nums[idx] == last)
            {
                count++;
            }
            else
            {
                max = Math.max(max, count);
                count = 1;
                last = nums[idx];
            }
        }
        max = Math.max(max, count);
        return max;
    }
    public static void main(String[] args) {
        int nums[] = {1, 1, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(maxCount(nums));
    }
}
