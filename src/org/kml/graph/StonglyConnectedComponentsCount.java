package org.kml.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StonglyConnectedComponentsCount {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(1).add(0);
        adj.get(2).add(1);
        adj.get(3).add(4);

        StonglyConnectedComponentsCount sol = new StonglyConnectedComponentsCount();
        int count = sol.kosaraju(V, adj);
        System.out.println("Number of strongly connected components: " + count);
    }
    private void dfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack)
    {
        visited[start] = true;
        for(int nei: adj.get(start))
        {
            if(!visited[nei])
                dfs(nei, adj, visited, stack);
        }
        if(stack != null)
            stack.push(start);
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int vert = 0; vert < V; vert++)
        {
            if(!visited[vert])
                dfs(vert, adj, visited, stack);
        }

        // reverse the edges
        ArrayList<ArrayList<Integer>> reversedAdjList = new ArrayList<>();
        for(int vert = 0; vert < V; vert++)
        {
            reversedAdjList.add(new ArrayList<>());
        }
        for(int vert = 0; vert < V; vert++)
        {
            for(int nei: adj.get(vert))
            {
                reversedAdjList.get(nei).add(vert);
            }
            // reset the visited array
            visited[vert] = false;
        }
        // do dfs for all unvisited nodes; each dfs is SCC
        int components = 0;
        while(!stack.isEmpty())
        {
            int curr = stack.pop();
            if(!visited[curr])
            {
                components++;
                dfs(curr, reversedAdjList, visited, null);
            }
        }
        return components;
    }
}
