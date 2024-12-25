package org.kml.graph.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinNumShortestWays {
    public static void main(String[] args) {
        List<List<Integer>> cities = new ArrayList<>();
        cities.add(Arrays.asList(0,6,7));
        cities.add(Arrays.asList(0,1,2));
        cities.add(Arrays.asList(1,2,3));
        cities.add(Arrays.asList(1,3,3));
        cities.add(Arrays.asList(6,3,3));
        cities.add(Arrays.asList(3,5,1));
        cities.add(Arrays.asList(6,5,1));
        cities.add(Arrays.asList(2,5,1));
        cities.add(Arrays.asList(0,4,5));
        cities.add(Arrays.asList(4,6,2));
        int count = 7;
        MinNumShortestWays sol = new MinNumShortestWays();
        System.out.println(sol.countPaths(count, cities));
    }
    List<List<int[]>> buildAdjacencyList(int n, List<List<Integer>> roads)
    {
        List<List<int[]>> adjList = new ArrayList<>();
        for(int city = 0; city < n; city++)
        {
            adjList.add(new ArrayList<>());
        }
        for(List<Integer> road: roads)
        {
            adjList.get(road.get(0)).add(new int[]{road.get(1), road.get(2)});
            adjList.get(road.get(1)).add(new int[]{road.get(0), road.get(2)});
        }
        return adjList;
    }

    public int countPaths(int n, List<List<Integer>> roads) {
        List<List<int[]>> adjList = buildAdjacencyList(n, roads);
        int[] dist = new int[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        dist[0] = 0;
        ways[0] = 1;
        queue.offer(new int[]{0, 0});

        while(!queue.isEmpty())
        {
            int[] curr = queue.poll();
            int currNode = curr[1];
            int distSoFar = curr[0];
            for(int[] adj: adjList.get(currNode))
            {
                System.out.println(Arrays.toString(adj));
                int adjNode = adj[0];
                int adjWt = adj[1];
                int newDist = distSoFar +adjWt;
                if(newDist < dist[adjNode])
                {
                    dist[adjNode] = newDist;
                    queue.offer(new int[]{newDist, adjNode});
                    ways[adjNode] = ways[currNode];
                }
                else if(newDist == dist[adjNode])
                {
                    ways[adjNode] += ways[currNode];
                }
            }
        }
        return ways[n - 1];
    }
}
