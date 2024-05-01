package org.example.patterns;

public class PrintTriangleLeftAlignedNumbersSeq {
    public static void main(String[] args) {
        print(5);
    }
    private static void print(int N)
    {
        int num = 1;
        for(int row = 0; row < N; row++)
        {
            for (int col = 0; col <= row; col++) {
                System.out.print(num++ + " ");
            }
            System.out.println();
        }
    }
}
