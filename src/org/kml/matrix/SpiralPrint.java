package org.kml.matrix;

import java.util.Arrays;

public class SpiralPrint {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        for (int[] a: arr)
        {
            System.out.println(Arrays.toString(a));
        }
        spiralPrint(arr);
    }
    public static void spiralPrint(int[][] arr)
    {
        int row = 0, col = 0, rowStart = 0, rowEnd = arr.length, colStart = 0, colEnd = arr[0].length;
        while (rowStart < rowEnd || colStart < colEnd)
        {
            //System.out.println("\nrow=" + row + ", col=" + col + ". rowStart=" + rowStart + ", rowEnd=" + rowEnd + ", colStart=" + colStart + ", colEnd=" + colEnd);
            while (col < colEnd)
            {
                System.out.print(arr[row][col++] + "->");
            }
            col--; // keep to back to previous value
            rowStart++; // reduce the row starting
            row = rowStart;
            //System.out.println("\nrow=" + row + ", col=" + col + ". rowStart=" + rowStart + ", rowEnd=" + rowEnd + ", colStart=" + colStart + ", colEnd=" + colEnd);
            while (row < rowEnd)
            {
                System.out.print(arr[row++][col] + "->");
            }
            row--; //Keep it back to previous value
            colEnd--;
            col = colEnd - 1;
            //System.out.println("\nrow=" + row + ", col=" + col + ". rowStart=" + rowStart + ", rowEnd=" + rowEnd + ", colStart=" + colStart + ", colEnd=" + colEnd);
            while (col>= colStart)
            {
                System.out.print(arr[row][col--] + "->");
            }
            col++; // keep it back to previous value
            rowEnd--;
            row = rowEnd - 1;
            //System.out.println("\nrow=" + row + ", col=" + col + ". rowStart=" + rowStart + ", rowEnd=" + rowEnd + ", colStart=" + colStart + ", colEnd=" + colEnd);
            while (row >= rowStart)
            {
                System.out.print(arr[row--][col]+"->");
            }
            colStart++;
            //row++;// keep it back to previous value
            //rowStart++;
            row = rowStart;
            col = colStart;
            //System.out.println("\nCircle complete");
        }
    }
}
