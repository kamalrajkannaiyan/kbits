package org.example.patterns;

public class PrintInvertedTriangleCenterAlignedAlpha {
    public static void main(String[] args) {
        print(5);
    }

    /**
     *
     * ABCDCBA
     *  ABCBA
     *   ABA
     *    A
     *
     * @param N
     */
    private static void print(int N)
    {
        for(int row = 0; row < N; row++)
        {
            int charsLen = 2 * (N - row) + 1;
            int maxColSize = 2 * N - 1;
            for (int col = 0; col < row; col++) {
                System.out.print("_");
            }
            char c = 'A';
            for(int col = 0; col < N - row; col++)
            {
                System.out.print(c);
                c++;
            }
            c--;
            c--;
            for(int col = 0; col < N - 1 - row; col++)
            {
                System.out.print((char)( c - col));
            }
            for (int col = row; col > 0; col--) {
                System.out.print("_");
            }
            System.out.println();
        }
    }
}
