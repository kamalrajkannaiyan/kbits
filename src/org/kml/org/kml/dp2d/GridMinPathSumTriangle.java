package org.kml.org.kml.dp2d;

public class GridMinPathSumTriangle {
    public static void main(String[] args) {
        int triangle[][] = {{1},
                {2, 3},
                {3, 6, 7},
                {8, 9, 6, 10}};
        int min = minPathSum(triangle);
        System.out.println(min);
    }

    private static int minPathSum(int[][] triangle)
    {
        return minPathSum(triangle, 0, 0);
    }
    private static int minPathSum(int[][] triangle, int row, int col)
    {
        if(row == triangle.length - 1) return triangle[row][col];
        return triangle[row][col] + Math.min(minPathSum(triangle, row + 1, col), minPathSum(triangle, row + 1, col + 1));
    }
}
