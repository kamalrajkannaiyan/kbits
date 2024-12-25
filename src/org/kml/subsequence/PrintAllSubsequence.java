package org.kml.subsequence;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequence
{
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        printAllSubsequence(arr);
    }
    private static void printAllSubsequence(int[] arr)
    {
        printAllSubsequence(0, arr, "");
    }
    private static void printAllSubsequence(int start, int[] arr, String res)
    {
        if (start >= arr.length)
        {
            System.out.println("Ans - " + res);
            return;
        }


        // pick
        printAllSubsequence(start + 1, arr, res + arr[start]);

        // do not pick
        printAllSubsequence(start + 1, arr, res);
    }
}
