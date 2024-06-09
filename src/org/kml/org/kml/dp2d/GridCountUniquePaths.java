package org.kml.org.kml.dp2d;

import java.util.Arrays;

public class GridCountUniquePaths {
    public static void main(String[] args) {
        int row = 3;
        int col = 3;
        System.out.println("uniquePathsMemoi(row,col)");
        System.out.println(uniquePathsMemoi(row,col));
        System.out.println("uniquePathsTabulation(row, col)");
        System.out.println(uniquePathsTabulation(row, col));
        System.out.println("uniquePathsTabulationSpaceOpt(row,col)");
        System.out.println(uniquePathsTabulationSpaceOpt(row,col));
    }

    private static int uniquePathsTabulationSpaceOpt(int row, int col)
    {
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
                    if(i > 0 && j > 0) tmp[j] = prev[j] + tmp[j - 1];
                    if (j == 0) tmp[j] = prev[j];
                    if (i == 0) tmp[j] = tmp[j - 1];
                }
            }
            prev = tmp;
        }
        System.out.println(Arrays.toString(prev));
        return prev[col - 1];
    }
    private static int uniquePathsTabulation(int row, int col)
    {
        int[][] cache = new int[row][col];
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (i ==0 && j == 0)
                {
                    cache[i][j] = 1;
                }
                else
                {
                    if(i > 0 && j > 0) cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
                    if (j == 0) cache[i][j] = cache[i - 1][j];
                    if (i == 0) cache[i][j] = cache[i][j - 1];
                }
            }
        }
        for (int[] row1: cache)
        {
            System.out.println(Arrays.toString(row1));
        }
        return cache[row - 1][col - 1];
    }
    private static int uniquePathsMemoi(int row, int col)
    {
        int[][] cache = new int[row][col];
        for (int[] row1: cache) Arrays.fill(row1, -1);
        int paths = uniquePaths(row - 1,col - 1, cache);
        for (int[] row1: cache)
        {
            System.out.println(Arrays.toString(row1));
        }
        return paths;
    }
    private static int uniquePaths(int i, int j, int[][] cache)
    {
        if(i < 0 || j < 0) return 0;
        if (i == 0 && j == 0) return 1;
        if (cache[i][j] != -1) return cache[i][j];
        return cache[i][j] = uniquePaths(i, j - 1, cache) + uniquePaths(i - 1, j, cache);
    }
}
