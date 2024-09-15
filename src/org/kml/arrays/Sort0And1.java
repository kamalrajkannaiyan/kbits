package org.kml.arrays;

import java.util.Arrays;

public class Sort0And1 {
    public static void sortZeroesAndOne(int[] arr) {
        //Your code goes here
        int left = 0, right = arr.length - 1, N = arr.length;
        while(left < right)
        {
            while(left < N && arr[left] == 0) left++;
            while(right >= 0 && arr[right] == 1) right--;
            if(left < N && right >=0 && left < right && arr[left] == 1 && arr[right] == 0)
            {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;

                left++;
                right--;
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        //int[] arr = {1,1,0,0,1,0 };
        int[] arr = {1,1,0,0,1,0,0,0,0,0,1 };
        sortZeroesAndOne(arr);
        System.out.println(Arrays.toString(arr));
    }
}
