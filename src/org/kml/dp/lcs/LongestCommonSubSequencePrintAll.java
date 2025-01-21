package org.kml.dp.lcs;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubSequencePrintAll {
    public static void main(String[] args) {
        String s= "ABC";
        String t= "XYZ";
        List<String> ans = all_longest_common_subsequences(s, t);
        for(int idx = 0; idx < ans.size(); idx++)
        {
            System.out.println(idx + "---" + ans.get(idx));
        }
    }
    public static List<String> all_longest_common_subsequences(String s, String t) {
        return all_longest_common_subsequences(s, t, 0, 0, "", new ArrayList<>());
    }
    public static List<String> all_longest_common_subsequences(String s, String t, int sIdx, int tIdx, String currSubSeq, List<String> longestSubSeqs) {
        if(sIdx == s.length() || tIdx == t.length())
        {
            longestSubSeqs.add(currSubSeq);
            return longestSubSeqs;
        }
        if(s.charAt(sIdx) == t.charAt(tIdx))
        {
            all_longest_common_subsequences(s, t, sIdx + 1, tIdx + 1, currSubSeq + s.charAt(sIdx), longestSubSeqs);
        }
        else
        {
            all_longest_common_subsequences(s, t, sIdx + 1, tIdx, currSubSeq, longestSubSeqs);
            all_longest_common_subsequences(s, t, sIdx, tIdx + 1, currSubSeq, longestSubSeqs);
        }
        return longestSubSeqs;
    }
}
