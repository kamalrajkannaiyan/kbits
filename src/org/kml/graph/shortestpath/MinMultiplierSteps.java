package org.kml.graph.shortestpath;

import java.util.*;

public class MinMultiplierSteps {
    public int minimumMultiplications(int[] arr, int start, int end) {
        int mod = (int)1e6;
        //Arrays.sort(arr);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0}); //{val, steps}
        Set<Integer> seen = new HashSet<>();
        seen.add(start);
        while(!queue.isEmpty())
        {
            int[] curr = queue.poll();
            int currVal = curr[0];
            int steps = curr[1];
            if(currVal == end)
            {
                return steps;
            }
            for(int multiplier: arr)
            {
                int newVal = (currVal * multiplier) % mod;
                if (newVal == end) return steps + 1;
                if(newVal < end && !seen.contains(newVal))
                {
                    queue.offer(new int[]{newVal, steps + 1});
                    seen.add(newVal);
                }
            }
            System.out.println("End of -- "+queue.size());
        }
        return -1;
    }

    public static void main(String[] args) {
        MinMultiplierSteps sol = new MinMultiplierSteps();
        int[] arr = {621, 259, 307, 405, 287, 302, 366, 80, 157, 409};
        int start = 864;
        int end = 26176;
        System.out.println(sol.minimumMultiplications(arr, start, end));
    }
}
