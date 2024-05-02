package org.kml.arrays.count;

public class CountConsecutive1s {
    public static void main(String[] args) {
        int[] nums =  {1, 1, 0, 1, 1, 1};
        System.out.println(count1s(nums));
    }
    private static int count1s(int[] nums)
    {
        int count1s = 0;
        int maxCount = 0;
        for (int num: nums)
        {
            if(num == 1)
            {
                count1s++;
            }
            else
            {
                maxCount = Math.max(maxCount, count1s);
                count1s = 0;
            }
        }
        return Math.max(maxCount, count1s);
    }
}
