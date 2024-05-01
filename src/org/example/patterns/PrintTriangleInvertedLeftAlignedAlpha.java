package org.example.patterns;

public class PrintTriangleInvertedLeftAlignedAlpha {
    public static void main(String[] args) {
        print(5);
    }

    private static void print(int N) {
        int num = 1;
        for (int row = 0; row < N; row++) {
            char c = 'A';
            for (int col = 0; col <= N - row; col++) {
                System.out.print(c + " ");
                if (c == 'Z') {
                    c = 'A';
                } else {
                    c++;
                }
            }
            System.out.println();
        }
    }
}
