package org.kml.graph;

import java.util.Arrays;

public class G09FloodFill {

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1}, {2, 2, 0}, {2, 2, 2}};
        print(grid);
        floodFill(grid, 2, 0, 3);
        System.out.println("After Flood Fill");
        print(grid);
    }
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static void floodFill(int[][] image, int sr, int sc, int newColor)
    {
        if (image == null || image.length == 0) return;
        dfs(image,  sr, sc, newColor);
    }

    private static void dfs(int[][] image, int sr, int sc, int newColor)
    {
        int existingColor = image[sr][sc];
        image[sr][sc] = newColor;
        for (int[] dir: dirs)
        {
            int adjR = sr + dir[0];
            int adjC = sc + dir[1];
            if (isWithinGrid(adjR, adjC, image.length, image[0].length)
                    && image[adjR][adjC] == existingColor)
            {
                dfs(image, adjR, adjC, newColor);
            }
        }
    }

    private static boolean isWithinGrid(int row, int col, int maxRow, int maxCol)
    {
        return row>=0 && row < maxRow && col >= 0 && col < maxCol;
    }
    private static void print(int[][] grid)
    {
        for (int[] row: grid)
        {
            System.out.println(Arrays.toString(row));
        }
    }
}
