package org.example.patterns;

public class PrintTriangleCenterAlignedAlpha {
    public static void main(String[] args) {
        print(5);
    }

    /**
     *
     *    A
     *   ABA
     *  ABCBA
     * ABCDCBA
     * @param N
     */
    private static void print(int N)
    {
        for(int row = 0; row < N; row++)
        {
            for (int col = 0; col < N - row - 1; col++) {
                System.out.print("_");
            }
            char c = 'A';
            for(int col = 0; col <= row; col++)
            {
                System.out.print(c);
                c++;
            }
            c--;
            c--;
            for(int col = 0; col < row; col++)
            {
                System.out.print((char)( c - col));
            }
            for (int col = N - row - 1; col > 0; col--) {
                System.out.print("_");
            }
            System.out.println();
        }
    }
}
