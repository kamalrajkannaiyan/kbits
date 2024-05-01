package org.example.patterns;

public class PrintInvertedTriangleCenterAlignedTODO {
    public static void main(String[] args) {
        print(5);
    }
    private static void print(int N)
    {
        for(int row = 0; row < N; row++)
        {
            for(int col = 0; col < row; col++)
            {
                System.out.print("_");
            }
            for(int col = 0; col < 2 * N - 1 - 2 * row; col++)
            {
                System.out.print("*");
            }
            for(int col = 0; col < row; col++)
            {
                System.out.print("_");
            }
            System.out.println();
        }
    }
}
