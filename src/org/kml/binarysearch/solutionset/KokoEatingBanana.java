package org.kml.binarysearch.solutionset;

public class KokoEatingBanana {
    public int minimumRateToEatBananas(int[] nums, int h) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int num: nums){
            if(num < min){
                min = num;
            }
            if(num > max){
                max = num;
            }
        }
        int low = 1, high = max;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canEat(nums, h, mid)){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canEat(int[] nums, int hr, int units){
        double totalHrs = 0;
        for(int num: nums){
            totalHrs += Math.ceil(num/(double)units);
        }
        return totalHrs <= hr;
    }

    public static void main(String[] args) {
        //int[] nums = {7,15,6,3};
        int[] nums = {805306368,805306368,805306368};
        int H = 8;
        H = 1000000000;
        KokoEatingBanana sol = new KokoEatingBanana();
        int minBananas = sol.minimumRateToEatBananas(nums, H);
        System.out.println(minBananas);
    }
}