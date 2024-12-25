package org.kml.binarysearch;

public class SearchElement {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int target = 2;
        System.out.println(searchElementIndex(nums, target));
        System.out.println(searchElementIndex(nums, 1));
        System.out.println("5 - "+searchElementIndex(nums, 5));
        System.out.println("0 - "+searchElementIndex(nums, 0));
        System.out.println("50 - "+searchElementIndex(nums, 50));
    }

    private static int searchElementIndex(int[] nums, int target)
    {
        int low = 0, high = nums.length - 1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
