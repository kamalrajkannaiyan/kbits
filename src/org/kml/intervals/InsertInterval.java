package org.kml.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] existingIntervals = {{1, 2}, {3, 4}, {5, 8}, {9, 15}};
        int[] newInterval = {2, 5};
        int[][] mergedIntervals = insertInterval(existingIntervals, newInterval);
        for (int[] interval: mergedIntervals)
        {
            System.out.print(Arrays.toString(interval) + ",");
        }
    }

    static boolean isOverlap(int[] a, int[] b)
    {
        if(a[1] < b[0] || b[1] < a[0])
            return false;
        return true;
    }
    public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();
        int idx = 0;
        while (idx < existingIntervals.length) {
            if (existingIntervals[idx][1] < newInterval[0]) {
                mergedIntervals.add(existingIntervals[idx]);
                idx++;
            } else {
                break;
            }
        }

        while (idx < existingIntervals.length) {
            if (isOverlap(newInterval, existingIntervals[idx])) {
                newInterval[0] = Math.min(newInterval[0], existingIntervals[idx][0]);
                newInterval[1] = Math.max(newInterval[1], existingIntervals[idx][1]);
                idx++;
            } else {
                break;
            }
        }
        mergedIntervals.add(newInterval);
        while (idx < existingIntervals.length) {
            mergedIntervals.add(existingIntervals[idx]);
            idx++;
        }
        int[][] ans = new int[mergedIntervals.size()][2];
        idx = 0;
        while (idx < ans.length) {
            ans[idx] = mergedIntervals.get(idx);
            idx++;
        }
        return ans;
    }
}