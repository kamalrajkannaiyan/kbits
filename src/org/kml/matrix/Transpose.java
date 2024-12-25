package org.kml.matrix;

import java.util.Arrays;

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

        transposeByTopRightDiagonal(mat);
        print(mat);
    }

    private static void transposeByTopRightDiagonal(int[][] mat)
    {
        System.out.println("Transpose by Secondary Diagonal");
        int M = mat.length;
        for(int row = 0; row < M; row++)
        {
            for (int col = 0; col < M - 1- row; col++)
            {
                int tmp = mat[row][col];
                //System.out.print(tmp + "," + mat[M - 1 - col][M - 1 - row] + "---");
                int temp = mat[row][col];
                mat[row][col] = mat[M - 1 - col][M - 1 - row];
                mat[M - 1 - col][M - 1 - row] = temp;
            }
            //System.out.println(Arrays.toString(mat[row]));
        }
    }
    private static void transpose(int[][] mat)
    {
        System.out.println("Transpose by Primary Diagonal");
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
