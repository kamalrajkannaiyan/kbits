package org.example.patterns;

public class PrintTriangleLeftAlignedRIghtAlignedNumbers {
    public static void main(String[] args) {
        print(6);
    }
    private static void print(int N)
    {
        for(int row = 0; row < N; row++)
        {
            for (int col = 0; col <= row; col++) {
                System.out.print(col + 1);
            }
            for (int col = 0; col < 2 * (N - 1 - row); col++)
            {
                System.out.print("_");
            }
            for (int col = 0; col <= row; col++) {
                System.out.print(row - col + 1);
            }
            System.out.println(" >>>> Row " + row + "/"+(N-1)+" spaces "+2 * (N - 1 - row));
        }
    }
}
