package org.kml.rec;

public class SumFirstNNumbers
{
    public static void main(String[] args) {
        System.out.println(sumFirstNNumbers(10));
    }
    private static int sumFirstNNumbers(int n)
    {
        if(n==0) return 0;
        return n + sumFirstNNumbers(n - 1);
    }
}
