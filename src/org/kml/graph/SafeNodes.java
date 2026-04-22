package org.kml.graph;

import java.util.*;

public class SafeNodes {
    public int[] eventualSafeNodes(int V, int[][] adj) {
        // build adjacency list graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int node = 0; node < V; node++) {
            graph.add(new ArrayList<>());
        }
        for (int node = 0; node < V; node++) {
            List<Integer> adjList = new ArrayList<>();
            for (int adjNode : adj[node]) {
                adjList.add(adjNode);
            }
            graph.get(node).addAll(adjList);
        }
        // Find terminal nodes
        Set<Integer> terminalNodes = new HashSet<>();
        for (int node = 0; node < V; node++) {
            if (graph.get(node).size() == 0) {
                terminalNodes.add(node);
            }
        }
        if (terminalNodes.size() == 0) {
            return new int[]{};
        }
        // From each node, find all paths;
        List<Integer> safeNodes = new ArrayList<>();
        boolean[] visited = new boolean[V];
        for (int node = 0; node < V; node++) {
            System.out.println("Processing -- " + node + visited[node]);
            visited[node] = true;
            List<List<Integer>> allPaths = findPaths(graph, visited, terminalNodes, node, new ArrayList<>());
            // if all paths reach terminal nodes, add node as safe Node
            // otherwise add to non-safeNodes
            List<Integer> lastNodes = new ArrayList<>();
            for (List<Integer> path : allPaths) {
                System.out.println(node + "-------" + path);
                int lastNode = path.get(path.size() - 1);
                if (terminalNodes.contains(lastNode)) {
                    lastNodes.add(lastNode);
                } else {
                    lastNodes.clear();
                    break;
                }
            }
            if (!lastNodes.isEmpty())
                safeNodes.add(node);
        }
        // while traversing if you come across un-safe node, mark the starting node as un-safe
        // return safe nodes
        int[] result = new int[safeNodes.size()];
        for (int safeNode = 0; safeNode < safeNodes.size(); safeNode++) {
            result[safeNode] = safeNodes.get(safeNode);
        }
        return result;
    }

    List<List<Integer>> findPaths(List<List<Integer>> graph, boolean[] visited, Set<Integer> terminalNodes, int node, List<Integer> path) {
        List<List<Integer>> allPaths = new ArrayList<>();
        //visited[node] = true;
        if (terminalNodes.contains(node)) {
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(node);
            allPaths.add(newPath);
            return allPaths;
        }
        path.add(node);
        for (int adjNode : graph.get(node)) {
            if (!visited[adjNode]) {
                allPaths.addAll(findPaths(graph, visited, terminalNodes, adjNode, path));
            } else {
                allPaths.add(new ArrayList<>(path));
            }
        }
        path.remove(path.size() - 1);
        return allPaths;
    }

    public static void main(String[] args) {
        int V = 7;
        int[][] adj = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };

        /* Creating an instance of
        Solution class */
        SafeNodes sol = new SafeNodes();

        /* Function call to get the eventually
        safe nodes in the given graph */
        int[] ans = sol.eventualSafeNodes(V, adj);

        // Output
        System.out.println("The eventually safe nodes in the graph are:");
        for (int node : ans) {
            System.out.print(node + " ");
        }
    }
}
