package org.kml.graph.djs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MakeLargeIsland
{
    public static void main(String[] args) {
        int grid[][] = {{1, 1}, {1, 1}};
        MakeLargeIsland obj = new MakeLargeIsland();
        int largestSize = obj.largestIsland(grid);
        System.out.println(largestSize);
    }
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int getVertex(int row, int col, int colSize)
    {
        return row * colSize + col;
    }

    public int largestIsland(int[][] grid) {
        int max = 0;
        // prepare Disjoint Set for the provided grid
        int ROWS = grid.length;
        int COLS = grid[0].length;
        DisjointSetMakeLargeIsland djs = new DisjointSetMakeLargeIsland(ROWS * COLS);
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if(grid[row][col] == 1)
                {
                    int vert = getVertex(row, col, COLS);
                    for (int[] dir:dirs)
                    {
                        int newRow = row + dir[0];
                        int newCol = col + dir[1];
                        if(newRow >=0 && newRow < ROWS
                                && newCol >= 0 && newCol < COLS
                                && grid[newRow][newCol] == 1)
                        {
                            int adj = getVertex(newRow, newCol, COLS);
                            djs.union(vert, adj);
                        }
                    }
                }
            }
        }
        // iterate through all the sea nodes and evaluate the largest island
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (grid[row][col] == 0)
                {
                    Set<Integer> adjRootSet = new HashSet<>();
                    for (int[] dir:dirs)
                    {
                        int newRow = row + dir[0];
                        int newCol = col + dir[1];
                        if(newRow >=0 && newRow < ROWS
                                && newCol >= 0 && newCol < COLS
                                && grid[newRow][newCol] == 1)
                        {
                            int adj = getVertex(newRow, newCol, COLS);
                            adjRootSet.add(djs.findRoot(adj));
                        }
                    }
                    int newSize = 1;
                    for (int adj:adjRootSet)
                    {
                        newSize += djs.size[adj];
                    }
                    max = Math.max(max, newSize);
                }
                else
                {
                    max = Math.max(max, djs.size[getVertex(row, col, COLS)]);
                }
            }
        }

        // return the largest island
        return max ;
    }
}
class DisjointSetMakeLargeIsland
{
    int[] root;
    int[] size;

    DisjointSetMakeLargeIsland(int n)
    {
        root = new int[n];
        size = new int[n];
        for(int vert = 0; vert < n; vert++)
        {
            root[vert] = vert;
            size[vert] = 1;
        }
    }

    int findRoot(int vert)
    {
        if(vert == root[vert])
            return vert;
        return root[vert] = findRoot(root[vert]);
    }

    void union(int u, int v)
    {
        int uroot = findRoot(u);
        int vroot = findRoot(v);
        if(uroot == vroot) return;
        if(size[uroot] < size[vroot])
        {
            root[uroot] = vroot;
            size[vroot] += size[uroot];
        }
        else
        {
            root[vroot] = uroot;
            size[uroot] += size[vroot];
        }
    }
}
