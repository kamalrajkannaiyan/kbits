package org.kml.matrix;

public class Transpose {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        print(mat);
        transpose(mat);
        print(mat);
    }
    private static void transpose(int[][] mat)
    {
        for (int row = 0; row < mat.length; row++)
        {
            for (int col = row + 1; col < mat[0].length; col++)
            {
                int tmp = mat[row][col];
                mat[row][col] = mat[col][row];
                mat[col][row] = tmp;
            }
        }
    }
    private static void print(int[][] mat)
    {
        for(int row = 0; row < mat.length; row++)
        {
            for (int col = 0; col < mat[0].length; col++)
            {
                System.out.print(mat[row][col] + "\t");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------");
    }
}
