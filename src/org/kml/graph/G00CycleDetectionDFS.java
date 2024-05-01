package org.kml.graph;

import java.util.List;

public class G00CycleDetectionDFS {

    private static boolean hasCycle(List<List<Integer>> adjList)
    {
        boolean[] visited = new boolean[adjList.size()];
        for (int node = 0; node < adjList.size(); node++)
        {
            if (!visited[node])
            {
                if (hasCycle(adjList, new int[]{node, -1}, visited)) return true;
            }
        }
        return false;
    }
    private static boolean hasCycle(List<List<Integer>> adjList, int[] src, boolean[] visited)
    {
        visited[src[0]] = true;
        for (int node: adjList.get(src[0]))
        {
            if(!visited[node])
            {
                if(hasCycle(adjList, new int[]{node, src[0]}, visited)) return true;
            }
            else if (node != src[1])
            {
                return true;
            }
        }
        return false;
    }
}
