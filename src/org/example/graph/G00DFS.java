package org.example.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class G00DFS {
    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int node = 0; node <=5; node++)
        {
            adjList.add(new ArrayList<>());
        }
        //adjList.add(0, Arrays.asList(new Integer[]{}));
        adjList.add(1, Arrays.asList(new Integer[]{2, 5}));
        adjList.add(2, Arrays.asList(new Integer[]{1, 3, 5}));
        adjList.add(3, Arrays.asList(new Integer[]{2, 4, 5}));
        adjList.add(4, Arrays.asList(new Integer[]{3, 5}));
        adjList.add(5, Arrays.asList(new Integer[]{1, 2, 3, 4}));
        boolean[] visited = new boolean[adjList.size()];
        Stack<Integer> stack = new Stack<>();
        List<Integer> dfsList = dfs(adjList, 2, visited, stack);
        System.out.println(dfsList);
        System.out.println("Topological Sort");
        while (!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
    }
    private static List<Integer> traverse(List<List<Integer>> adjList)
    {
        List<Integer> traveralList = new ArrayList<>();
        boolean[] visited = new boolean[adjList.size()];
        Stack<Integer> stack = new Stack<>();
        for (int node = 0; node < adjList.size(); node++)
        {
            if(!visited[node])
            {
                traveralList.addAll(dfs(adjList, node, visited, stack));
            }
        }
        return traveralList;
    }

    private static List<Integer> dfs(List<List<Integer>> adjList, int node, boolean[] visited, Stack<Integer> stack)
    {
        List<Integer> ans = new ArrayList<>();
        ans.add(node);
        visited[node] = true;
        for(int adjNode: adjList.get(node))
        {
            if(!visited[adjNode])
            {
                ans.addAll(dfs(adjList, adjNode, visited, stack));
            }
        }
        stack.push(node);
        return ans;
    }
}
