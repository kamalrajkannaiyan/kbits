package org.kml.arrays;

public class FindOddOccurrenceNumber {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,4,1,2};
        System.out.println(findOddOccurrenceNumber(nums));
    }

    private static int findOddOccurrenceNumber(int[] nums)
    {
        int odd = 0;
        for (int num:nums)
        {
            odd ^= num;
        }
        return odd;
    }
}
