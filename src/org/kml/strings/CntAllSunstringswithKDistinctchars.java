package org.kml.strings;

import java.util.HashMap;
import java.util.Map;

public class CntAllSunstringswithKDistinctchars {
    public static int cntAllSubstringsWithKchars_1(String s, int k) {
        int cnt = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            // shrink until window has less than k distinct
            while (map.size() >= k) {
                // all substrings starting from left..right and ending till end
                cnt += s.length() - right;

                char d = s.charAt(left);
                map.put(d, map.get(d) - 1);
                if (map.get(d) == 0) map.remove(d);
                left++;
            }
        }
        return cnt;
    }

    public static int cntAllSubstringsWithKchars(String s, int k){
        int cnt = 0;
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()){
            char curr = s.charAt(right);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            while(map.size() >= k){
                cnt += s.length() - right;

                char d = s.charAt(left);
                map.put(d, map.get(d) - 1);
                if(map.get(d) == 0) map.remove(d);
                left++;
            }
            right++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        String s= "ABCBA";
        System.out.println(cntAllSubstringsWithKchars(s, 2));
    }
}
