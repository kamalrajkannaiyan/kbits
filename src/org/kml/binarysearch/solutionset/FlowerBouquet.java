package org.kml.binarysearch.solutionset;

public class FlowerBouquet {
    public int roseGarden(int n, int[] nums, int k, int m) {
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            max = Math.max(max, num);
        }

        int low = 1, high = max;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canBuild(nums, k, m, mid)){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canBuild(int[] nums, int k, int m, int day){
        int total = 0;
        int currTotal = 0;
        for(int num: nums){
            if(num <= day){
                currTotal++;
            } else {
                currTotal = 0;
            }
            if(currTotal == k){
                total += currTotal;
                currTotal = 0;
            }
        }

        return total == (k * m);
    }

    public static void main(String[] args) {
        int[] nums = {7, 7, 7, 7, 13, 11, 12, 7};
        int k = 3, m = 2;
        FlowerBouquet sol = new FlowerBouquet();
        int minDay = sol.roseGarden(nums.length, nums, k, m);
        System.out.println(minDay);
    }
}


