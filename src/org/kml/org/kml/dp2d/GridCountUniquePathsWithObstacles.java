package org.kml.org.kml.dp2d;

import java.util.Arrays;

public class GridCountUniquePathsWithObstacles {
    public static void main(String[] args) {
        int row = 3;
        int col = 3;
        int[][] grid = {{0, 0, 0},
                {0, -1, 0},
                {0, 0, 0}};
        System.out.println("uniquePathsMemoi(row,col)");
        System.out.println(uniquePathsMemoi(grid));
        System.out.println("uniquePathsTabulation(row, col)");
        System.out.println(uniquePathsTabulation(grid));
        System.out.println("uniquePathsTabulationSpaceOpt(row,col)");
        System.out.println(uniquePathsTabulationSpaceOpt(grid));
    }

    private static int uniquePathsTabulationSpaceOpt(int[][] grid)
    {
        int row = grid.length, col = grid[0].length;
        int[] prev = new int[col];
        for (int i = 0; i < row; i++)
        {
            int[] tmp = new int[col];
            for (int j = 0; j < col; j++)
            {
                if (i ==0 && j == 0)
                {
                    tmp[j] = 1;
                }
                else
                {
                    if (i >= 0 && j >= 0 && grid[i][j] == -1) tmp[j] = 0;
                    else if(i > 0 && j > 0) tmp[j] = prev[j] + tmp[j - 1];
                    if (j == 0) tmp[j] = prev[j];
                    if (i == 0) tmp[j] = tmp[j - 1];
                }
            }
            prev = tmp;
        }
        System.out.println(Arrays.toString(prev));
        return prev[col - 1];
    }
    private static int uniquePathsTabulation(int[][] grid)
    {
        int[][] cache = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (i ==0 && j == 0)
                {
                    cache[i][j] = 1;
                }
                else
                {
                    if (i >= 0 && j >= 0 && grid[i][j] == -1) cache[i][j] = 0;
                    else if (i > 0 && j > 0) cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
                    if (j == 0) cache[i][j] = cache[i - 1][j];
                    if (i == 0) cache[i][j] = cache[i][j - 1];
                }
            }
        }
        for (int[] row1: cache)
        {
            System.out.println(Arrays.toString(row1));
        }
        return cache[grid.length - 1][grid[0].length - 1];
    }
    private static int uniquePathsMemoi(int[][] grid)
    {
        int row = grid.length, col = grid[0].length;
        int[][] cache = new int[row][col];
        for (int[] row1: cache) Arrays.fill(row1, -1);
        int paths = uniquePaths(grid, row - 1,col - 1, cache);
        for (int[] row1: cache)
        {
            System.out.println(Arrays.toString(row1));
        }
        return paths;
    }
    private static int uniquePaths(int[][] grid,int i, int j, int[][] cache)
    {
        if(i >= 0 && j >= 0 && grid[i][j] == -1) return 0;
        if(i < 0 || j < 0) return 0;
        if (i == 0 && j == 0) return 1;
        if (cache[i][j] != -1) return cache[i][j];
        return cache[i][j] = uniquePaths(grid,i, j - 1, cache) + uniquePaths(grid,i - 1, j, cache);
    }
}
