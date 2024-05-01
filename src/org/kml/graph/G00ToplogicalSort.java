package org.kml.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class G00ToplogicalSort {
    private static List<Integer> topologicalSort(List<List<Integer>> adjList)
    {
        List<Integer> sortedList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[adjList.size()];
        for (int node = 0; node < adjList.size(); node++)
        {
            if (!visited[node])
            {
                topologicalSort(adjList, node, visited, stack);
            }
        }
        while (!stack.isEmpty())
        {
            sortedList.add(stack.pop());
        }
        return sortedList;
    }
    private static void topologicalSort(List<List<Integer>> adjList, int node, boolean[] visited, Stack<Integer> stack)
    {
        visited[node] = true;
        for (int adj: adjList.get(node))
        {
            if (!visited[adj])
            {
                topologicalSort(adjList, adj, visited, stack);
            }
        }
        stack.push(node);
    }
}
