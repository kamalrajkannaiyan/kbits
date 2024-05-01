package org.example.patterns;

public class PrintInvertedTriangleLeftAlignedColNumbers {
    public static void main(String[] args) {
        print(5);
    }
    private static void print(int N)
    {
        for(int row = 0; row < N; row++)
        {
            for (int col = 0; col < N - row; col++) {
                System.out.print(col + 1);
            }
            System.out.println();
        }
    }
}
