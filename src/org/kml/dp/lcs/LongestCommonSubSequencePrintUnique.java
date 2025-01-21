package org.kml.dp.lcs;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubSequencePrintUnique {
    public static void main(String[] args) {
        String s= "abaaa";
        String t= "baabaca";
        List<String> ans = all_longest_common_subsequences(s, t);
        for(String ss: ans)
        {
            System.out.println("---" + ss);
        }
    }
    public static List<String> all_longest_common_subsequences(String s, String t) {
        return all_longest_common_subsequences(s, t, 0, 0, "", new ArrayList<>());
    }
    public static List<String> all_longest_common_subsequences(String s, String t, int sIdx, int tIdx, String currSubSeq, List<String> longestSubSeqs) {
        if(sIdx == s.length() || tIdx == t.length())
        {
            if(!longestSubSeqs.isEmpty())
            {
                if(currSubSeq.length() > longestSubSeqs.get(0).length())
                    longestSubSeqs.clear();
                else if(currSubSeq.length() < longestSubSeqs.get(0).length())
                    return longestSubSeqs;
            }
            if(!longestSubSeqs.contains(currSubSeq))
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
