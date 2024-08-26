package org.kml.binarysearch;

public class SquareRoot {
    public static void main(String[] args) {
        int root = rootBy2(29);
        System.out.println("Root of " + root);
    }
    private static int rootBy2(int n)
    {
        int low = 1, high = n;
        while (low <= high)
        {
            int root = low + (high - low)/2;
            long square = root * root;
            if(square == n)
            {
                return root;
            }
            if (square < n)
            {
                low = root + 1;
            }
            else
            {
                high = root - 1;
            }
        }
        return high;
    }
    private static int rootBy2_1(int n)
    {
        for (int i = 0; i <= n; i++) {
            if(i * i >n) return i - 1;
        }
        return 1;
    }
}
