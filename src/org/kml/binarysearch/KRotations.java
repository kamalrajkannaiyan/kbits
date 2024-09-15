package org.kml.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KRotations {
    public int findKRotation(ArrayList<Integer> nums) {
        return findMin(nums);
    }

    public static int findMin(List<Integer> arr) {
        int low = 0, high = arr.size() - 1;
        int min = Integer.MAX_VALUE;
        int idx = Integer.MAX_VALUE;
        while(low <= high)
        {
            if(arr.get(low) < arr.get(high))
            {
                if(arr.get(low) < min)
                {
                    min = arr.get(low);
                    idx = low;
                }
                break;
            }
            int mid = low + (high - low)/2;
            if(arr.get(low) <= arr.get(mid))
            {
                if(arr.get(low) < min)
                {
                    min = arr.get(low);
                    idx = low;
                }
                low = mid + 1;
            }
            else
            {
                if(arr.get(mid) < min)
                {
                    min = arr.get(mid);
                    idx = mid;
                }
                high = mid - 1;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        //[4, 5, 6, 7, 0, 1, 2, 3];
        List<Integer> nums = Arrays.asList(4, 5, 6, 7, 1, 2, 3);
        System.out.println(findMin(nums));
    }
}