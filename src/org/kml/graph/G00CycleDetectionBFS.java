package org.kml.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G00CycleDetectionBFS {

    private boolean hasCycle(List<List<Integer>> adjList)
    {
        boolean[] visited = new boolean[adjList.size()];
        for (int node = 0; node < adjList.size(); node++)
        {
            if (!visited[node])
            {
                if (hasCycle(adjList, node, visited)) return true;
            }
        }
        return false;
    }
    private static boolean hasCycle(List<List<Integer>> adjList, int src, boolean[] visited)
    {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, -1});
        visited[src] = true;

        while (!queue.isEmpty())
        {
            int[] node = queue.poll();
            for (int adj: adjList.get(node[0]))
            {
                if (!visited[adj])
                {
                    queue.offer(new int[]{adj, src});
                    visited[adj] = true;
                }
                else if(adj != node[1])
                {
                    return true;
                }
            }
        }
        return false;
    }
}
