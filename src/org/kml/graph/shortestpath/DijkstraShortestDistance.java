package org.kml.graph.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraShortestDistance
{
    static void addEdge(List<List<List<Integer>>> adjList, int u, int v, int w) {
        List<List<Integer>> nei = adjList.get(u);
        List<Integer> edge = new ArrayList<>();
        edge.add(v);
        edge.add(w);
        nei.add(edge);

        List<List<Integer>> nei2 = adjList.get(v);
        List<Integer> edge1 = new ArrayList<>();
        edge1.add(u);
        edge1.add(w);
        nei2.add(edge1);
    }
    public static void main(String[] args) {
        DijkstraShortestDistance obj = new DijkstraShortestDistance();
        int V = 9;
        List<List<List<Integer>>> adjList = new ArrayList<>();
        for(int vert = 0; vert < V; vert++)
        {
            adjList.add(new ArrayList<>());
        }
        addEdge(adjList,0, 1, 4);
        addEdge(adjList,0, 7, 8);
        addEdge(adjList,1, 2, 8);
        addEdge(adjList,1, 7, 11);
        addEdge(adjList,2, 3, 7);
        addEdge(adjList,2, 8, 2);
        addEdge(adjList,2, 5, 4);
        addEdge(adjList,3, 4, 9);
        addEdge(adjList,3, 5, 14);
        addEdge(adjList,4, 5, 10);
        addEdge(adjList,5, 6, 2);
        addEdge(adjList,6, 7, 1);
        addEdge(adjList,6, 8, 6);
        addEdge(adjList,7, 8, 7);

        int[] dist = obj.findShortestDistance(V, adjList, 0);
        System.out.println(Arrays.toString(dist));
    }
    int[] findShortestDistance(int V, List<List<List<Integer>>> adjList, int src)
    {
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        dist[src] = 0;
        queue.offer(new int[]{0, src});
        while (!queue.isEmpty())
        {
            int[] curr = queue.poll();
            int distSoFar = curr[0];
            int currNode = curr[1];
            for (List<Integer> nei: adjList.get(currNode))
            {
                int neiDist = distSoFar + nei.get(1);
                int neiNode = nei.get(0);
                if( neiDist < dist[neiNode])
                {
                    dist[neiNode] = neiDist;
                    queue.offer(new int[]{neiDist, neiNode});
                }
            }
        }
        return dist;
    }
}
