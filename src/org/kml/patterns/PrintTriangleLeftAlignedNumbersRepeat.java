package org.kml.patterns;

public class PrintTriangleLeftAlignedNumbersRepeat {
    public static void main(String[] args) {
        print(5);
    }
    private static void print(int N)
    {
        for(int row = 0; row < N; row++)
        {
            for (int col = 0; col <= row; col++) {
                System.out.print(row + 1);
            }
            System.out.println();
        }
    }
}
