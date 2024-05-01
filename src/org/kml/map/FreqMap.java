package org.kml.map;

import java.util.HashMap;
import java.util.Map;

public class FreqMap {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,3,4,4,4,4,5,5,5,5,5,6,7,8,9};
        Map<Integer, Integer> freqMap = findFreMap(arr);
        System.out.println(freqMap);
        int minElement = -1, maxElement = -1;
        int minElementCount = Integer.MAX_VALUE, maxElementCount = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry: freqMap.entrySet())
        {
            if(entry.getValue() < minElementCount)
            {
                minElementCount = entry.getValue();
                minElement = entry.getKey();
            }
            else if(entry.getValue() > maxElementCount)
            {
                maxElementCount = entry.getValue();
                maxElement = entry.getKey();
            }
        }
        System.out.println("Min freq element " + minElement);
        System.out.println("Max freq element " + maxElement);
    }
    private static Map<Integer, Integer> findFreMap(int[] arr)
    {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int element : arr)
        {
            freqMap.put(element, freqMap.getOrDefault(element, 0) + 1);
        }
        return freqMap;
    }
}
