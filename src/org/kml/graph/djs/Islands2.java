package org.kml.graph.djs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Islands2
{
    public static void main(String[] args) {
        //int n = 4, m = 5, k = 4, A[][] = {{1,1}, {1,1},{0,1},{3,3},{3,4}};
        int n = 4, m = 5, k = 4, A[][] ={{0,0},{0,0},{1,1},{1,0},{0,1},{0,3},{1,3},{0,4}, {3,2}, {2,2},{1,2}, {0,2}};
        Islands2 islands2 = new Islands2();
        List<Integer> ans = islands2.numOfIslands(n, m, A);
        System.out.println(ans);
    }
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int getVertex(int row, int col, int colSize)
    {
        return row * colSize + col;
    }
    public List<Integer> numOfIslands(int n, int m, int[][] A) {
        List<Integer> count = new ArrayList<>();
        DisjointSet djs = new DisjointSet(n*m);
        int ROWS = n;
        int COLS = m;
        int[][] grid = new int[ROWS][COLS];
        for(int[] edge: A)
        {
            int row = edge[0];
            int col = edge[1];
            if(grid[row][col] == 1)
            {
                count.add(count.get(count.size() - 1));
                continue;
            }
            grid[row][col] = 1;

            int vert = getVertex(row, col, COLS);
            if(djs.add(vert))
            {
                Set<Integer> adjVertSet = new HashSet<>();
                for(int[] dir: dirs)
                {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if(newRow >= 0 && newRow < ROWS
                            && newCol >=0 && newCol < COLS
                            && grid[newRow][newCol] == 1)
                    {
                        int adjVert = getVertex(newRow, newCol, COLS);
                        adjVertSet.add(adjVert);
                    }
                }
                for(int adjVert: adjVertSet)
                {
                    djs.union(vert, adjVert);
                }
            }
            count.add(djs.countIslands());
        }
        return count;
    }
}
class DisjointSet
{
    int[] root;
    int[] size;
    DisjointSet(int n)
    {
        root = new int[n];
        size = new int[n];
        for(int vert = 0; vert < n; vert++)
        {
            root[vert] = vert;
            size[vert] = 0;
        }
    }
    int countIslands()
    {
        int count = 0;
        for(int vert = 0; vert < root.length; vert++)
        {
            if(vert == root[vert] && size[vert] != 0) count++;
        }
        return count;
    }
    int findRoot(int vert)
    {
        if(root[vert] == vert)
            return vert;

        return root[vert] = findRoot(root[vert]);
    }
    boolean add(int vert)
    {
        int vertroot = findRoot(vert);
        root[vert] = vertroot;
        size[vertroot]++;
        return true;
    }
    void union(int u, int v)
    {
        int ru = findRoot(u);
        int rv = findRoot(v);
        if(ru == rv) return;
        if(size[ru] < size[rv])
        {
            root[ru] = root[rv];
            size[rv] += size[ru];
        }
        else
        {
            root[rv] = root[ru];
            size[ru] += size[rv];
        }
    }
}
