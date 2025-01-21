package org.kml.dp.lcs;

public class LongestCommonSubSequenceLength {
    static int longestCommonSubsequence(String s1, String s2) {
        //int s1Len = 0, s2Len = 0;
        int cache[][] = new int[s1.length() + 1][s2.length() + 1];

        // base case
        // s1 len is 0
        for (int s2Len = 0; s2Len <= s2.length(); s2Len++)
            cache[0][s2Len] = 0;

        // s2 len is 0
        for (int s1Len = 0; s1Len <= s1.length(); s1Len++)
            cache[s1Len][0] = 0;

        for (int s1Len = 1; s1Len <= s1.length(); s1Len++) {
            for (int s2Len = 1; s2Len <= s2.length(); s2Len++) {
                if (s1.charAt(s1Len - 1) == s2.charAt(s2Len - 1)) {
                    cache[s1Len][s2Len] = 1 + cache[s1Len - 1][s2Len - 1];
                } else {
                    cache[s1Len][s2Len] = Math.max(cache[s1Len - 1][s2Len],
                            cache[s1Len][s2Len - 1]);
                }
            }
        }
        return cache[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        System.out.println(longestCommonSubsequence(s1, s2));
    }
}
