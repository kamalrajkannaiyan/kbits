package org.kml.dp.lcs;

public class PalindromeSubsequence
{
    public static void main(String[] args) {
        String s = "bbabcbcab";//""bbbab";
        int ans = findLongestCommonSubsequencePalindromeLen(s, new StringBuffer(s).reverse().toString());
        System.out.println(ans);
        int ans1 = findLongestCommonSubsequencePalindromeLenSpace(s, new StringBuffer(s).reverse().toString());
        System.out.println(ans1);
    }
    private static int findLongestCommonSubsequencePalindromeLen(String s1, String s2)
    {
        int s1Len = s1.length();
        int s2Len = s2.length();
        int[][] mat = new int[s1Len + 1][s2Len + 1];
        for(int s1Idx = 1; s1Idx <= s1Len; s1Idx++)
        {
            for(int s2Idx = 1; s2Idx <= s2Len; s2Idx++)
            {
                if(s1.charAt(s1Idx - 1) == s2.charAt(s2Idx - 1))
                {
                    mat[s1Idx][s2Idx] = 1 + mat[s1Idx - 1][s2Idx - 1];
                }
                else
                {
                    mat[s1Idx][s2Idx] = Math.max(mat[s1Idx][s2Idx - 1], mat[s1Idx - 1][s2Idx]);
                }
            }
        }
        return mat[s1Len][s2Len];
    }
    private static int findLongestCommonSubsequencePalindromeLenSpace(String s1, String s2)
    {
        int s1Len = s1.length();
        int s2Len = s2.length();
        int[] prev = new int[s2Len + 1];
        for(int s1Idx = 1; s1Idx <= s1Len; s1Idx++)
        {
            int[] curr = new int[s2Len + 1];
            for(int s2Idx = 1; s2Idx <= s2Len; s2Idx++)
            {
                if(s1.charAt(s1Idx - 1) == s2.charAt(s2Idx - 1))
                {
                    curr[s2Idx] = 1 + prev[s2Idx - 1];
                }
                else
                {
                    curr[s2Idx] = Math.max(curr[s2Idx - 1], prev[s2Idx]);
                }
            }
            prev = curr;
        }
        return prev[s2Len];
    }
}
