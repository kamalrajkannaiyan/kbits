package org.example.patterns;

public class PrintTriangleLeftAlignedEndingAlphaPreferred {
    public static void main(String[] args) {
        print(5);
    }
    private static void print(int N)
    {
        for(int row = 0; row < N; row++)
        {
            char c = (char) ('A' + N - 1);
            for (int col = row; col >= 0; col--) {
                System.out.print((char)(c - col));
            }
            System.out.println();
        }
    }
}
