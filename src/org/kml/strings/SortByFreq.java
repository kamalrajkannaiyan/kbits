package org.kml.strings;

import java.util.*;

public class SortByFreq {
    public static String frequencySort(String s) {
        // build frequency map
        Map<Character, Integer> freqMap = new HashMap<>();
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            list.add(c);
        }
        // build list with sorting based on frequency map
        Collections.sort(list, (a, b) -> freqMap.get(b) - freqMap.get(a));

        // buld string based on above list
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(frequencySort(s));
    }
}
