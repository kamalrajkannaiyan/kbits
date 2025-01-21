package org.kml.duplicates;

import java.util.Arrays;

public class FindDuplicates {
    public static void main(String[] args) {
        //int[] nums = {1, 2, 2};
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(Arrays.toString(nums));
        System.out.println(findDuplicateValue(nums));
    }

    static int findDuplicateValue(int[] nums)
    {
        int fast = nums[0];
        int slow = nums[0];

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                break;
            }
        }

        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }
}
