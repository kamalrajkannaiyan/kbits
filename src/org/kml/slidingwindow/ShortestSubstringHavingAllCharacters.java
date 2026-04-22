package org.kml.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class ShortestSubstringHavingAllCharacters {
    public static String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        for(char c: t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, minLen = Integer.MAX_VALUE;
        String minStr = "";
        while(right < s.length()){
            char c = s.charAt(right);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            while(hasAllChars(sMap, tMap)){
                if((right - left + 1) < minLen){
                    minLen = (right - left + 1);
                    minStr = s.substring(left, right + 1);
                }
                sMap.put(s.charAt(left), sMap.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
            right++;
        }
        return minStr;
    }

    static boolean hasAllChars(Map<Character, Integer> sMap, Map<Character, Integer> tMap){
        for(Map.Entry<Character, Integer> entry: tMap.entrySet()){
            if(entry.getValue() > sMap.getOrDefault(entry.getKey(), 0)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
