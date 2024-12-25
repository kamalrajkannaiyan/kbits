package org.kml.dp.subarray;

public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int[] arr = {2, 5, 2, 3};
        int K = 5;
        System.out.println(hasSubArraySumEqualsK(arr, K));
        System.out.println(countSubArraySumEqualsK(arr, K));
    }

    static int countSubArraySumEqualsK(int[] arr, int K)
    {
        return countSubArraySumEqualsK(arr, K, arr.length - 1, K);
    }
    static boolean hasSubArraySumEqualsK(int[] arr, int K)
    {
        return hasSubArraySumEqualsK(arr, K, arr.length - 1, K);
    }
    static boolean hasSubArraySumEqualsK(int[] arr, int K, int idx, int original)
    {
        if (K == 0) return true;
        if (K < 0 || idx < 0) return false;
        boolean pick = hasSubArraySumEqualsK(arr, K - arr[idx], idx - 1, original);
        if (pick)
        {
            return true;
        }
        boolean skip = hasSubArraySumEqualsK(arr, original, idx - 1, original);
        return pick || skip;
    }
    static int countSubArraySumEqualsK(int[] arr, int K, int idx, int original)
    {
        if (K == 0) return 1;
        if (K < 0 || idx < 0) return 0;
        int pick = countSubArraySumEqualsK(arr, K - arr[idx], idx - 1, original);
        int skip = countSubArraySumEqualsK(arr, original, idx - 1, original);
        return pick + skip;
    }
}
