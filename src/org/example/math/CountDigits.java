package org.example.math;

public class CountDigits {
    public static void main(String[] args) {
        System.out.println(countDigits(7));
        System.out.println(countDigits(17));
        System.out.println(countDigits(10));
        System.out.println(countDigits(100));
        System.out.println(countDigits(701));
    }
    private static int countDigits(int num)
    {
        if(num < 10) return 1;
        return 1 + countDigits(num/10);
    }
}
