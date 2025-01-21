package org.kml.intervals;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindNumRooms {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{9,15},{12,14}};
        int tot = findSets(intervals);
        System.out.println(tot);
    }
    public static int findSets(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        for (int[] interval: intervals)
        {
            System.out.print(Arrays.toString(interval) + ", ");
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for(int[] interval: intervals)
        {
            if(!pq.isEmpty())
            {
                int[] lastInterval = pq.poll();
                if(interval[0] < lastInterval[1])
                {
                    pq.offer(interval);
                    pq.offer(lastInterval);
                }
                else
                {
                    pq.offer(interval);
                }
            }
            else
            {
                pq.offer(interval);
            }
        }
        return pq.size();
    }
}
