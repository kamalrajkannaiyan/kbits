package org.kml.graph.shortestpath;

import java.util.*;

public class DijkstraShortestDistancePath
{
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[][] edges = {{1,2,2}, {2,5,5}, {2,3,4}, {1,4,1},{4,3,3},{3,5,1}};
//        System.out.println(Arrays.toString(dist));
        List<Integer> path = obj.shortestPath(5, 0, edges);
        System.out.println(path);
    }
}


class Solution {
    List<List<int[]>> buildAdjacencyList(int n, int[][] edges)
    {
        List<List<int[]>> adjList = new ArrayList<>();
        for(int vert = 0; vert < n; vert++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int[] edge: edges)
        {
            adjList.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adjList.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        return adjList;
    }
    public List<Integer> shortestPath(int n, int m, int[][] edges)
    {
        n = n + 1;
        List<List<int[]>> adjList = buildAdjacencyList(n, edges);
        int[] dist = new int[n];
        int[] from = new int[n];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int vert = 0; vert < n; vert++)
        {
            dist[vert] = Integer.MAX_VALUE;
            from[vert] = vert;
        }

        dist[1] = 0;
        queue.offer(new int[]{0, 1});
        from[1] = 1;

        while(!queue.isEmpty())
        {
            int[] curr = queue.poll();
            int distSoFar = curr[0];
            int currNode = curr[1];
            for(int[] edge: adjList.get(currNode))
            {
                //System.out.println(Arrays.toString(edge));
                int adjNode = edge[0];
                int edgeWt = edge[1];
                int newDist = distSoFar + edgeWt;
                if(newDist < dist[adjNode])
                {
                    dist[adjNode] = newDist;
                    queue.offer(new int[]{newDist, adjNode});
                    from[adjNode] = currNode;
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        int node = n  - 1;
        while(node != from[node])
        {
            path.add(node);
            node = from[node];
        }
        path.add(1);
        path.add(path.size());
        int left = 0, right = path.size() - 1;
        while(left < right)
        {
            int tmp = path.get(left);
            path.set(left, path.get(right));
            path.set(right, tmp);
            left++;
            right--;
        }
        return path;
    }
}







