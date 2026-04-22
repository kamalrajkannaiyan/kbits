package org.kml.graph.shortestpath;

import java.util.*;

public class MinCostWithTimeLImit {
    public static int minCost(int maxTime, int[][] edges, int[] passingFees) {
        // build adjaceny list graph
        List<List<int[]>> graph = new ArrayList<>();
        for (int city = 0; city < passingFees.length; city++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        // build duration array
        int[] times = new int[passingFees.length];
        Arrays.fill(times, Integer.MAX_VALUE);
        // define Priority Queue
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0, passingFees[0]});
        times[0] = 0;

        // iterate over the PQ
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currCity = curr[0];
            int currCityTime = curr[1];
            int costSoFar = curr[2];
            if (currCityTime > maxTime) continue;
            if (currCity == passingFees.length - 1) return costSoFar;
            for (int[] adj : graph.get(currCity)) {
                int adjCity = adj[0];
                int adjCityTime = adj[1];

                int newTime = currCityTime + adjCityTime;
                if (newTime < times[adjCity]) {
                    times[adjCity] = newTime;
                    pq.offer(new int[]{adjCity, newTime, passingFees[adjCity] + costSoFar});
                }
            }
        }
        // return the result
        return -1;
    }

    public static void main(String[] args) {
        int[][] edges  = {{0,1,10},{1,2,10},{2,5,10},{0,3,1},{3,4,10},{4,5,15}};
        int[] passingFees = {5,1,2,20,20,3};
        int maxTime = 29;
        System.out.println(minCost(maxTime, edges, passingFees));
    }
}
