package org.kml.dp;

public class CountPartitionWithDiff {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int diff = 2;
        System.out.println(countPartitions(arr.length, diff, arr));
    }

    public static int countPartitions(int n, int diff, int[] arr) {
        int totSum = 0;
        for (int num : arr) {
            totSum += num;
        }
        int cnt = 0;
        for (int target = 0; target < totSum; target++) {
            if (2 * target + diff == totSum) {
                cnt = cnt + (int) (countPartitions(arr, target, arr.length - 1) % (10e9 + 7));
                cnt = (int) (cnt % (10e9 + 7));
            }
        }
        return cnt;
    }

    private static int countPartitions(int[] nums, int total, int idx) {
        if (idx < 0) return 0;
        if (total == 0) return 1;
        if (idx == 0) {
            return (total == nums[idx] ? 1 : 0);
        }
        int skip = countPartitions(nums, total, idx - 1);
        skip = (int) (skip % (10e9 + 7));
        int pick = 0;
        if (total >= nums[idx]) {
            pick = countPartitions(nums, total - nums[idx], idx - 1);
            pick = (int) (pick % (10e9 + 7));
        }
        return (int) ((skip + pick) % (10e9 + 7));
    }
}

