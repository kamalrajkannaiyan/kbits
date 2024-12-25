package org.kml.subsequence;

public class KnapSackRecKml
{
    public static void main(String[] args) {
        int[] val = {10, 40, 30};
        int[] wt = {5, 4, 6};
        int W = 7;
        int max = knapsackMax(wt, val, W, wt.length - 1);
        System.out.println(max);
    }

    static int knapsackMax(int[] wt, int[] val, int W, int idx)
    {
        System.out.println("Calling with W - " + W + " idx - " + idx);
        if (W <= 0 || idx < 0)
            System.out.println(" ReturningReturningReturning -- W - " + W + " idx - " + idx);
        if (W <= 0) return 0;
        if (idx < 0) return 0;

        int pick = 0;
        if (wt[idx] <= W)
            pick = val[idx] + knapsackMax(wt, val, W - wt[idx], idx - 1);
        int skip = knapsackMax(wt, val, W, idx - 1);
        int max = Math.max(pick, skip);
        System.out.println("W - " + W + " idx - " + idx + " max - " + max);
        return max;
    }
}
