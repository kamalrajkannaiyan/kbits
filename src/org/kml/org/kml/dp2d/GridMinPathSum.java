package org.kml.org.kml.dp2d;

import sun.nio.cs.ext.MacHebrew;

import java.util.Arrays;

public class GridMinPathSum {
    public static void main(String[] args) {
        int[][] grid = {{5, 9, 6}, {11, 5, 2}};
        for (int[] row:grid)
        {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("minPathSumMemoi(grid)");
        int min = minPathSumMemoi(grid);
        System.out.println(min);
        System.out.println("minPathSumTabu(grid)");
        int min1 = minPathSumTabu(grid);
        System.out.println(min1);

        System.out.println("minPathSumSpaceOpt(grid)");
        int min2 = minPathSumSpaceOpt(grid);
        System.out.println(min2);
    }
    private static int minPathSumSpaceOpt(int[][] grid) {
        int[] prev = new int[grid[0].length];
        for (int row = 0; row < grid.length; row++)
        {
            int[] curr = new int[grid[0].length];
            for (int col = 0; col < grid[0].length; col++) {
                if (row == 0 && col == 0)
                {
                    curr[col] = grid[row][col];
                }
                else
                {
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if (row > 0) up = prev[col];
                    if (col > 0) left = curr[col - 1];
                    curr[col] = grid[row][col] + Math.min(up, left);
                }
            }
            prev = curr;
        }
        System.out.println(Arrays.toString(prev));
        return prev[grid[0].length - 1];
    }
    private static int minPathSumTabu(int[][] grid) {
        int[][] res = new int[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++)
        {
            for (int col = 0; col < grid[0].length; col++) {
               if (row == 0 && col == 0)
                   res[row][col] = grid[row][col];
               else
               {
                   int up = Integer.MAX_VALUE;
                   int left = Integer.MAX_VALUE;
                   if (row > 0) up = res[row - 1][col];
                   if (col > 0) left = res[row][col - 1];
                   res[row][col] = grid[row][col] + Math.min(up, left);
               }
            }
        }
        for (int[] row: res)
        {
            System.out.println(Arrays.toString(row));
        }
        return res[grid.length - 1][grid[0].length - 1];
    }
    private static int minPathSumMemoi(int[][] grid)
    {
        int[][] cache = new int[grid.length][grid[0].length];
        for (int[] row:cache)
        {
            Arrays.fill(row, -1);
        }
        int min = minPathSum(grid, grid.length - 1, grid[0].length - 1, cache);
        for (int[] row:cache)
        {
            System.out.println(Arrays.toString(row));
        }
        return min;
    }

    private static int minPathSum(int[][] grid, int row, int col,int[][] cache)
    {
        if (row == 0 && col == 0) return grid[row][col];
        if (row < 0 || col < 0) return Integer.MAX_VALUE;
        if(cache[row][col] != -1) return cache[row][col];
        return cache[row][col] = grid[row][col] + Math.min(minPathSum(grid, row - 1, col, cache), minPathSum(grid, row, col - 1, cache));
    }
}
