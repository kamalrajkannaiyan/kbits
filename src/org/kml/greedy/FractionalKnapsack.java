package org.kml.greedy;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FractionalKnapsack {
    public static void main(String[] args) {
        //8 2 10 1 9 7 2 6 4 9
        //10 1 7 7 5 1 8 6 8 7
        //21
        List<Integer> val = Arrays.asList(8, 2, 10, 1, 9, 7, 2, 6, 4, 9);
        List<Integer> wt = Arrays.asList(10, 1, 7, 7, 5, 1, 8, 6, 8, 7);
        List<Integer> idx = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        int capacity = 21;
        System.out.println("Wt  - " + wt);
        System.out.println("Val - " + val);
        System.out.println("Idx - " + idx);
        System.out.println(fractionalKnapsack(val, wt, capacity));
    }

    static double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity)
    {
        double maxVal = 0;
        //Queue<Integer> pq = new PriorityQueue<>((a, b) -> (int)((val.get(b)/(double)wt.get(b)) - (val.get(a)/(double)wt.get(a))));
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (int) (((val.get(b) / (double) wt.get(b)) - (val.get(a) / (double) wt.get(a))) * 1e6));
        for (int idx = 0; idx < val.size(); idx++) {
            pq.offer(idx);
        }

        System.out.println("Pq  - " + pq);
        while (capacity > 0 && !pq.isEmpty())
        {
            int idx = pq.poll();
            System.out.println("Picking - Idx : " + idx + " - wt : " + wt.get(idx) + " - val : " + val.get(idx) + " - capacity : " + capacity + " - ratio : " + val.get(idx)/(double)wt.get(idx));
            if (capacity >= wt.get(idx))
            {
                maxVal += val.get(idx);
                capacity -= wt.get(idx);
            }
            else
            {
                maxVal += (val.get(idx) / (double) wt.get(idx)) * capacity;
                break;
            }
        }
        return maxVal;
    }
}
