package org.kml.math;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(reverse(102));
        System.out.println(reverse(100));
    }
    public static int reverseAI(int n) {
        if (n < 10) {
            return n;
        } else {
            return reverse(n / 10) * 10 + n % 10;
        }
    }
    public static int reverse(int n) {
        return reverse(n/10, n%10);
    }
    public static int reverse(int v, int reversed) {
        if (v > 0) {
            return reverse(v / 10, reversed * 10 + v % 10);
        }
        return reversed;
    }
    private static int reverseLoop(int N)
    {
        int reverse = 0;
        while(N!=0)
        {
            int digit = N%10;
            reverse = reverse*10+digit;
            N = N/10;
        }
        return reverse;
    }
}
