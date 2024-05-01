package org.kml.patterns;

public class PrintTriangleCenterAlignedStars {
    public static void main(String[] args) {
        print(5);
    }
    private static void print(int N)
    {
        for(int row = 0; row < N; row++)
        {
            // chars -> 2i + 1
            for (int j = 0; j < N - 1 - row; j++) {
                System.out.print("_");
            }
            // For printing the stars in each row
            for (int j = 0; j < 2 * row + 1; j++) {

                System.out.print("*");
            }

            // For printing the spaces after the stars in each row
            for (int j = 0; j < N - row - 1; j++)
            {
                System.out.print("_");
            }
            System.out.println();
            //System.out.println("------------" + row + "---"+(2 * row + 1));
        }
    }
}
